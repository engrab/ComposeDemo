package com.example.chatapp.screen.chatui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R
import com.example.chatapp.components.AppIcon
import com.example.chatapp.components.AppText
import com.example.chatapp.ui.theme.gray_f8
import com.example.chatapp.ui.theme.interFont
import com.example.chatapp.ui.theme.violet_a4

@Composable
fun ChatSearchBar(
    modifier: Modifier = Modifier,
) {

    var search by remember {
        mutableStateOf("")
    }

    BasicTextField(
        modifier = Modifier.padding(horizontal = 24.dp),
        value = search,
        onValueChange = {
            search = it
        }
    ) {
        Row(
            modifier = Modifier
                .background(
                    color = gray_f8,
                    shape = CircleShape
                )
                .padding(start = 16.dp)
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)

        ) {
            AppIcon(
                icon = R.drawable.search,
                modifier = Modifier.padding(horizontal = 10.dp).size(22.dp)
            )
            Box {
                if (search.isEmpty()){
                    AppText(
                        text = stringResource(R.string.search),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = interFont,
                            fontWeight = FontWeight.W500,
                            color = violet_a4
                        )
                    )
                }

                it.invoke()
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ChatSearchBarPreview() {
    ChatSearchBar()

}