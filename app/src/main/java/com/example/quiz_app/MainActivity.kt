package com.example.quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var questionNo = 0
    var correctAnswersCount = 0
    var questions = listOf("",
        "Какой язык программирования используется для разработки Android-приложений? \n\n A) Kotlin \n\n B) Python \n\n C) C++",
        "Что такое переменная в программировании? \n\n A) Место для хранения данных \n\n B) Функция \n\n C) Ошибка",
        "Какой оператор используется для сравнения в Kotlin? \n\n A) = \n\n B) == \n\n C) ===",
        "Что такое массив? \n\n A) Набор данных одного типа \n\n B) Одиночное значение \n\n C) Функция",
        "Какой метод используется для вывода текста в консоль в Kotlin? \n\n A) print() \n\n B) println() \n\n C) echo()",
        "Что такое класс в объектно-ориентированном программировании? \n\n A) Шаблон для создания объектов \n\n B) Переменная \n\n C) Функция",
        "Какой из следующих типов данных является целым числом? \n\n A) Int \n\n B) String \n\n C) Float",
        "Какой метод используется для создания нового объекта в Kotlin? \n\n A) new \n\n B) create \n\n C) constructor",
        "Что такое условный оператор? \n\n A) Оператор, который выполняет код в зависимости от условия \n\n B) Оператор, который всегда выполняется \n\n C) Оператор, который вызывает ошибку",
        "Какой из следующих языков является языком разметки? \n\n A) HTML \n\n B) Java \n\n C) Kotlin"
    )
    var rightAnswers = listOf(0, 0, 0, 1, 0, 1, 0, 0, 2, 0, 0) // Индексы правильных ответов (0 - A, 1 - B, 2 - C)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            showToast(0) // A
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            showToast(1) // B
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            showToast(2) // C
        }

        updateQuestion()

        val authorButton: Button = findViewById(R.id.authorButton)
            authorButton.setOnClickListener {
                val intent = Intent(this, AuthorActivity::class.java)
                startActivity(intent)

            }

}

    fun showToast(answer: Int) {
        if (answer == rightAnswers[questionNo]) {
            Toast.makeText(applicationContext, "ВЕРНО!", Toast.LENGTH_SHORT).show()
            correctAnswersCount++
        } else {
            Toast.makeText(applicationContext, "НЕВЕРНО!", Toast.LENGTH_SHORT).show()
        }
        updateQuestion()
    }

    fun updateQuestion() {
        questionNo++
        if (questionNo < questions.size) {
            val textView: TextView = findViewById(R.id.textView)
            textView.text = questions[questionNo]
        } else {
            val intent = Intent(this, RezScreenActivity::class.java)
            intent.putExtra("SCORE", correctAnswersCount)
            intent.putExtra("TOTAL_QUESTIONS", questions.size-1)
            startActivity(intent)
            finish()
        }
    }
}