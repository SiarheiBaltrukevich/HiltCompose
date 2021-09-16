package com.boltic28.hiltcompose.elements

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boltic28.hiltcompose.elements.buttons.ButtonStyle

@Composable
fun AppTextButton(text: String, style: ButtonStyle, onClick: () -> Unit){

    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = style.defaultBackground,
            disabledContentColor = style.disabledBackground,
            contentColor = style.pressedBackground
        ),
        modifier = Modifier
            .padding(style.horizontalPadding, style.verticalPadding)
            .height(style.height)
            .width(style.width)
    ) {
        Text(
            text = text,
            color = style.defaultText
        )
    }

}