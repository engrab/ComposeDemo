package com.example.chatapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerWidth(
    with: Int = 10
) {
    Spacer(modifier = Modifier.width(width = with.dp))
}

@Composable
fun SpacerHeight(
    height: Int = 10
) {
    Spacer(modifier = Modifier.height(height = height.dp))
}