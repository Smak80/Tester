package ru.smak.tester.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.smak.tester.R
import ru.smak.tester.models.Test
import ru.smak.tester.ui.theme.TesterTheme

@Composable
fun TestCard(
    cardInfo: Test,
    modifier: Modifier = Modifier,
    background: Color = Color.Unspecified,
    isAnswered: Boolean = false,
    onAnswer: (String)->Unit = {},
){
    var userInput by remember{ mutableStateOf("") }
    Card (
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(containerColor = background)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = cardInfo.task,
                    modifier = Modifier.weight(0.7f).padding(8.dp),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                OutlinedTextField(
                    value = userInput,
                    onValueChange = { newValue -> userInput = newValue },
                    modifier = Modifier.weight(0.3f).padding(8.dp),
                    enabled = !isAnswered ,
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                    )
                )
            }
            IconButton(onClick = {
                onAnswer(userInput)
            },
                enabled = !isAnswered

            ) {
                Icon(
                    painterResource(R.drawable.twotone_done_outline_24),
                    tint = Color.Green,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
@Preview
fun TestCardPreview(){
    TesterTheme {
        TestCard(cardInfo = Test())
    }
}

@Composable
fun Results(
    text: String,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
        )
    }

}

@Composable
@Preview
fun ResultsPreview(){
    TesterTheme {
        Results(
            "Ваш результат: 4 из 5",
            modifier = Modifier.fillMaxSize()
        )
    }
}