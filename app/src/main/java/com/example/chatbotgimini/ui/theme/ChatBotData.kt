package com.example.chatbotgimini.ui.theme

data class ChatBotData(
    val massage: String,
    val role: String
)

enum class ChatRoleEnum(val role : String){
    USER("user"),
    MODEl("model")
}