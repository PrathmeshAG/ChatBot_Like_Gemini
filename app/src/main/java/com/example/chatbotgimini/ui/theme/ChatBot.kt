package com.example.chatbotgimini.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatbotgimini.Components.ChatFooter
import com.example.chatbotgimini.Components.ChatHeader
import com.example.chatbotgimini.Components.ChatList


@Composable
fun ChatBot(
    viewModel: ChatBotVm = viewModel()

) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(Color(0xFFD5CA9F))
    ) {
        ChatHeader()
        Box(modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (viewModel.list.isEmpty()){
                Text(text = "No Chat Available", color = Color.Black)


            }else
            ChatList(list = viewModel.list)

        }
        ChatFooter {
            if (it.isNotEmpty()) {
                viewModel.sendMessage(it)
            }

        }
    }
}
