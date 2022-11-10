package com.firstapp.math_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var QuestionTextView : TextView
    lateinit var answerView: EditText

    var firstNumber = 0
    var secondNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        QuestionTextView = findViewById(R.id.textView)
        answerView = findViewById(R.id.AnswerEditText)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            checkAnswer()
            
        }

        setNewQuestion()

    }
    override fun onResume() {
        super.onResume()

        answerView.setText("")
        setNewQuestion()
    }


    fun checkAnswer() {
        val answerText = answerView.text.toString()
        val answer = answerText.toIntOrNull()
        val correctAnswer = firstNumber + secondNumber

        var answeredCorrect = false
        if(answer == correctAnswer) {
            answeredCorrect = true
        }

        val intent = Intent(this, AnswerActivity::class.java)
        intent.putExtra("answeredCorrect", answeredCorrect)
        startActivity(intent)
    }

    fun setNewQuestion() {
        firstNumber = (1 .. 10).random()
        secondNumber = (1..10).random()

        QuestionTextView.text = "$firstNumber + $secondNumber"


        




    }
}