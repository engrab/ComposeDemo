package com.example.chatapp.screen.chatui.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatapp.screen.chatui.components.ChatHeader
import com.example.chatapp.screen.chatui.components.ChatLine
import com.example.chatapp.screen.chatui.components.ChatRow
import com.example.chatapp.screen.chatui.components.ChatSearchBar
import com.example.chatapp.screen.chatui.components.chatStoryList
import com.example.chatapp.screen.chatui.components.chattingList

@Composable
fun ChatUIScreen(modifier: Modifier = Modifier) {

    ChatRow(
        modifier = modifier,
        header = {
            ChatHeader()
        },
        search = {
            ChatSearchBar()
        },
        stories = {
            chatStoryList()
        },
        line = {
            ChatLine()
        },
        chat = {
            chattingList()
        }
    )
}