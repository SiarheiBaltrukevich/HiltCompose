package com.boltic28.hiltcompose.elements.buttons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.boltic28.hiltcompose.ui.theme.*

sealed class ButtonStyle(
    val height: Dp = 60.dp,
    val width: Dp = 90.dp,
    val defaultBackground: Color = Gray,
    val pressedBackground: Color = Black40,
    val disabledBackground: Color = Black20,
    val defaultText: Color = Black100,
    val disabledText: Color = Black20,
    val cornerRadius: Dp = 0.dp,
    val horizontalPadding: Dp = 6.dp,
    val verticalPadding: Dp = 12.dp
) {
    object Default : ButtonStyle(
        defaultText = LightWhite100
    )
    object Green : ButtonStyle(
        defaultBackground = com.boltic28.hiltcompose.ui.theme.Green
    )
    object Red : ButtonStyle(
        defaultBackground = com.boltic28.hiltcompose.ui.theme.Red
    )
    object Yellow : ButtonStyle(
        defaultBackground = com.boltic28.hiltcompose.ui.theme.Yellow
    )
}