package ru.smak.tester

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.smak.tester.ui.TestCard
import ru.smak.tester.ui.theme.TesterTheme
import ru.smak.tester.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TesterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.Top
                    ) {
                        for(i in 0..mainViewModel.activeTaskId) {
                            TestCard(
                                mainViewModel.cards[i],
                                modifier = Modifier.padding(10.dp),
                                background = mainViewModel.cardsBackground[i].value,
                                onAnswer = mainViewModel::onAnswer
                            )
                        }
                    }
                }
            }
        }
    }
}
