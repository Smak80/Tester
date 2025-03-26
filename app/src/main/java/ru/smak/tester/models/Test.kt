package ru.smak.tester.models

import kotlin.random.Random

enum class Operation(val symbol: Char){
    PLUS('+'),
    MINUS('-'),
    TIMES('×'),
    DIV('÷'),
}

class Test {
    val a: Int
    val b: Int
    val operation: Operation

    var userAnswer: Int? = null

    val isAnswerCorrect: Boolean?
        get() = userAnswer?.let{ it == result }

    val task: String
        get() = buildString{
            append(a)
            append(' ')
            append(operation.symbol)
            append(' ')
            append(b)
            append(" =")
        }

    val result: Int
        get() = when(operation){
            Operation.PLUS -> a + b
            Operation.MINUS -> a - b
            Operation.TIMES -> a * b
            Operation.DIV -> a / b
        }

    init{
        operation = Operation.entries.toTypedArray()[Random.nextInt(Operation.entries.size)]
        when (operation){
            Operation.TIMES -> {
                a = Random.nextInt(21) - 10 // a = Random.nextInt(21) <=> a \in [0; 21) <=> 0 <= a < 21
                b = Random.nextInt(11)
            }
            Operation.DIV -> {
                val r = Random.nextInt(21) - 10
                b = Random.nextInt(1, 11)
                a = r * b
            }
            else -> {
                a = Random.nextInt(41) - 20
                b = Random.nextInt(21)
            }
        }
    }
}