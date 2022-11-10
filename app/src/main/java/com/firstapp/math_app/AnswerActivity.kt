package com.firstapp.math_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    lateinit var resultView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        resultView = findViewById(R.id.answerView)

        val answeredCorrect = intent.getBooleanExtra("answeredCorrect", false)

        if(answeredCorrect) {
            resultView.text = "Rätt svar!"
        } else {
            resultView.text = "Fel svar!"

         }

    }
}