package ru.smak.tester.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.smak.tester.ui.theme.TesterTheme

@Composable
fun TestCard(
    modifier: Modifier = Modifier,
){
    var userInput by remember{ mutableStateOf("") }
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "")
            OutlinedTextField(
                value = userInput,
                onValueChange = { newValue -> userInput = newValue},
                modifier = Modifier
            )
        }
        IconButton(onClick = {

        }) {

        }
    }
}

@Composable
@Preview
fun TestCardPreview(){
    TesterTheme {
        TestCard()
    }
}