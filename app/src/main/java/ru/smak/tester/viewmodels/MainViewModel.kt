package ru.smak.tester.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import ru.smak.tester.models.Test

class MainViewModel : ViewModel(){

    private val testsCount = 5

    val cards: MutableList<Test> = mutableListOf()
    var activeTaskId by mutableIntStateOf(0)
    var finished by mutableStateOf(false)
    val cardsBackground = mutableStateListOf<MutableState<Color>>()

    init{
        createNewTests()
    }

    fun createNewTests(){
        cards.clear()
        repeat(5) {
            cards.add(Test())
        }
        cardsBackground.add(mutableStateOf(Color.Unspecified))
        finished = false
    }

    fun onAnswer(userText: String){
        userText.toIntOrNull()?.let {
            cards[activeTaskId].userAnswer = it
            cardsBackground[activeTaskId].value = when (cards[activeTaskId].isAnswerCorrect) {
                true -> Color(0f, 1f, 0f, 0.3f)
                false -> Color(1f, 0f, 0f, 0.3f)
                else -> Color.Unspecified
            }
            if (activeTaskId < testsCount - 1) {
                activeTaskId++
                cardsBackground.add(mutableStateOf(Color.Unspecified))
            }
            else
                finished = true
        }
    }

}
