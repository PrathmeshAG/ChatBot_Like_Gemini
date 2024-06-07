package com.example.chatbotgimini.ui.theme

sealed interface ChatBotUiState{
    data object ideal : ChatBotUiState

    data object Loading : ChatBotUiState

    data class Success(val ChatData : String) : ChatBotUiState
    data class Error(val chatError : String): ChatBotUiState
}