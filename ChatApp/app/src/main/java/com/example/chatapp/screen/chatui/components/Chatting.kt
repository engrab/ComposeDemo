package com.example.chatapp.screen.chatui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R
import com.example.chatapp.components.AppIcon
import com.example.chatapp.components.AppText
import com.example.chatapp.screen.chatui.domain.ChatModal
import com.example.chatapp.screen.chatui.domain.chatModalList
import com.example.chatapp.ui.theme.black_1a
import com.example.chatapp.ui.theme.blue_30
import com.example.chatapp.ui.theme.green_5a
import com.example.chatapp.ui.theme.interFont
import com.example.chatapp.ui.theme.violet_a4

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Chatting(
    modifier: Modifier = Modifier,
    data: ChatModal
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (!data.isGroup) {
                Box {
                    AppIcon(
                        modifier = Modifier.size(54.dp),
                        icon = data.image,

                        )
                    if (data.isOnline) {
                        Spacer(
                            modifier = Modifier
                                .background(
                                    Color.White,
                                    CircleShape
                                )
                                .size(14.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = green_5a
                                    )
                                }
                                .padding(2.dp)
                                .align(alignment = Alignment.BottomEnd)
                        )
                    }
                }

            } else {

                FlowRow(
                    maxItemsInEachRow = 2,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)

                ) {
                    repeat(chatModalList.size) {
                        if (it < 3) {
                            AppIcon(
                                modifier = Modifier.size(25.dp),
                                icon = chatModalList[it].image,
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .drawBehind {
                                drawCircle(
                                    color = blue_30
                                )
                            }
                            .size(25.dp),
                        contentAlignment = Alignment.Center

                    ) {

                        AppText(
                            text = "3",
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontFamily = interFont,
                                fontWeight = FontWeight.W500,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            ),

                            )
                    }

                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                AppText(
                    text = data.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = interFont,
                        fontWeight = FontWeight.W500,
                        color = black_1a

                    )
                )
                AppText(
                    text = data.message,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = interFont,
                        fontWeight = FontWeight.W400,
                        color = violet_a4

                    )
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.End
        ) {
            AppText(
                text = data.time,
                style = TextStyle(
                    fontSize = 11.sp,
                    fontFamily = interFont,
                    fontWeight = FontWeight.W500,
                    color = violet_a4
                )
            )

            if (!data.isDoubleTick) {

                Box(
                    modifier = Modifier
                        .drawBehind {
                            drawCircle(
                                color = blue_30
                            )
                        }
                        .size(25.dp),
                    contentAlignment = Alignment.Center

                ) {

                    AppText(
                        text = "2",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = interFont,
                            fontWeight = FontWeight.W600,
                            color = Color.White
                        ),
                    )
                }
            } else {
                AppIcon(
                    icon = R.drawable.seen_checkmark,
                    tint = if (data.receive) Color.Unspecified else violet_a4

                )
            }


        }

    }


}

fun LazyListScope.chattingList() {
    items(chatModalList, key = { it.id }) {

        Chatting(data = it)
    }
}


//@Preview(showBackground = true)
//@Composable
//private fun ChattingPreview() {
//    Chatting(
//        modifier = TODO(),
//        data = ChatModal(
//            1,
//            "John",
//            R.drawable.photo,
//            message = "Ovlia is typing...",
//            time = "12:35",
//            isDoubleTick = true,
//            isOnline = true
//        )
//    )
//}