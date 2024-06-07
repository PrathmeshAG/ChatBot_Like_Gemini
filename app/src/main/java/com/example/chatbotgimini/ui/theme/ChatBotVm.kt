package com.example.chatbotgimini.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotVm : ViewModel() {
    val list by lazy {
        mutableStateListOf<ChatBotData>()
    }
    private val geneAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro" ,
            apiKey = ApiKey
        )

    }
    fun sendMessage(message : String) = viewModelScope.launch {
        val chat : Chat = geneAI.startChat()
        list.add(ChatBotData(message, ChatRoleEnum.USER.role))

        chat.sendMessage(
            content (ChatRoleEnum.USER.role){text(message) }

        ).text?.let {
            list.add(ChatBotData(it, ChatRoleEnum.MODEl.role))
        }

    }
}