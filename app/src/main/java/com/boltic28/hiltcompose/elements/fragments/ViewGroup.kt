package com.boltic28.hiltcompose.elements.fragments

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boltic28.hiltcompose.elements.AppTextButton
import com.boltic28.hiltcompose.elements.buttons.ButtonStyle

@Composable
fun ButtonsGroup(sendTo: String,
    onApplyAction: () -> Unit,
    onWriteAction: (String) -> Unit,
    onReadAction: () -> String,
    onChangeNameAction: () -> String
) {

    val textTerminal = remember { mutableStateOf("your message") }
    val editTextValue = remember { mutableStateOf("message") }
    val sentTo = remember { mutableStateOf(sendTo)}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Message for ${sentTo.value}")
        TextField(
            value = editTextValue.value,
            onValueChange = {
                editTextValue.value = it
            },
            modifier = Modifier
                .padding(24.dp, 24.dp, 24.dp, 0.dp)
                .fillMaxWidth()
        )
        Row {
            AppTextButton(text = "Ready", style = ButtonStyle.Yellow) {
                onApplyAction.invoke()
                textTerminal.value = editTextValue.value
            }
            AppTextButton(text = "Send", style = ButtonStyle.Red) {
                onWriteAction.invoke(textTerminal.value)
                textTerminal.value = "Your message is sent to ${sentTo.value}"
            }
            AppTextButton(text = "Read", style = ButtonStyle.Green) {
                textTerminal.value = onReadAction.invoke()
            }
            AppTextButton(text = "Name", style = ButtonStyle.Default){
                sentTo.value = onChangeNameAction.invoke()
                println("->> ${sentTo.value}")
            }
        }
        Text(text = textTerminal.value)
    }
}
