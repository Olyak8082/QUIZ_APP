package com.example.quiz_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class AuthorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.author)

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}