package com.example.chatapp.screen.chatui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.R
import com.example.chatapp.components.AppIcon
import com.example.chatapp.components.AppText
import com.example.chatapp.screen.chatui.domain.Story
import com.example.chatapp.screen.chatui.domain.storyData
import com.example.chatapp.ui.theme.interFont
import com.example.chatapp.ui.theme.photo_gradient

@Composable
fun ChatStoryRow(
    modifier: Modifier = Modifier,
    data: Story
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        AppIcon(
            icon = data.icon,
            modifier = modifier
                .size(50.dp)
                .drawBehind {
                    drawCircle(
                        brush = photo_gradient,
                        style = Stroke(
                            width = 2.dp.toPx()
                        )
                    )
                }
                .padding(2.dp)
        )
        AppText(modifier = modifier, data.name, style = TextStyle(
            color = Color.Black,
            fontFamily = interFont,
            fontWeight = FontWeight.W300,

        ))


    }


}

fun LazyListScope.chatStoryList(){
    items(storyData, key = { it.id}){
        ChatStoryRow(data = it)
    }
}

@Preview
@Composable
private fun ChatStoryRowPreview() {
    ChatStoryRow(data = Story(1, "David", R.drawable.photo))
}