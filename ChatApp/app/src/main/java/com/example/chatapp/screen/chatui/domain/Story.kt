package com.example.chatapp.screen.chatui.domain

import androidx.annotation.DrawableRes
import com.example.chatapp.R

data class Story(
    val id: Int,
    val name: String,
    @DrawableRes val icon: Int
)
val storyData = listOf(
    Story(1, "David", R.drawable.photo),
    Story(2, "Ashly", R.drawable.photo_2),
    Story(3, "Travis", R.drawable.photo_3),
    Story(4, "Khan", R.drawable.photo_4),
    Story(5, "Rooman", R.drawable.photo_5),
    Story(6, "Adam", R.drawable.photo_6),
)
