package com.example.chatapp.screen.chatui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R
import com.example.chatapp.components.AppIcon
import com.example.chatapp.ui.theme.black_1a
import com.example.chatapp.ui.theme.interFont
import com.example.chatapp.ui.theme.red_eb

@Composable
fun ChatHeader(
    modifier: Modifier = Modifier
) {

    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = black_1a,
                fontFamily = interFont,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp
            )
        ) {
            append(stringResource(R.string.hello))
        }
        append(" ")
        withStyle(
            style = SpanStyle(
                color = black_1a,
                fontFamily = interFont,
                fontWeight = FontWeight.W700
            )
        ) {
            append("David")
        }
    }
    Row(
        modifier = modifier.padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppIcon(
                icon = R.drawable.photo,
                modifier = Modifier.size(46.dp)
            )
            Text(text)

        }
        Box {
            AppIcon(
                icon = R.drawable.notification,
                modifier = Modifier.size(24.dp)
            )
            Spacer(
                modifier = modifier
                    .size(8.dp)
                    .background(
                        color = red_eb,
                        shape = CircleShape
                    )
                    .align(Alignment.TopEnd)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatHeaderPreview() {
    ChatHeader()
}