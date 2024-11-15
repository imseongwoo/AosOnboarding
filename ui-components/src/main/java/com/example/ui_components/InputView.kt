package com.example.ui_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputView(
    state: State<String>,
    label: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    OutlinedTextField(
        value = state.value,
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyLarge
    )
}

@Composable
@Preview
fun InputViewPreview() {
    val state = remember { mutableStateOf("preview") }
    InputView(
        state = state,
        label = "test",
        placeholder = "test",
        onValueChange = {},
        modifier = Modifier
    )
}