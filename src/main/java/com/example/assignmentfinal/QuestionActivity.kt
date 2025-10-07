package com.example.assignmentfinal // Corrected package name to match your project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class QuestionActivity : AppCompatActivity() {

    private val questions = FlashcardRepository.questions
    private var currentIndex = 0
    private var score = 0
    private var answered = false

    private lateinit var txtQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var txtFeedback: TextView
    private lateinit var txtProgress: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        txtQuestion = findViewById(R.id.txtQuestion)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)
        txtFeedback = findViewById(R.id.txtFeedback)
        txtProgress = findViewById(R.id.txtProgress)

        btnTrue.setOnClickListener { onAnswer(true) }
        btnFalse.setOnClickListener { onAnswer(false) }
        btnNext.setOnClickListener { onNext() }

        showQuestion()
    }

    private fun showQuestion() {
        val q = questions[currentIndex]
        txtQuestion.text = q.question
        btnTrue.isEnabled = true // Re-enable buttons for the new question
        btnFalse.isEnabled = true
        txtFeedback.visibility = View.INVISIBLE
        answered = false
        txtProgress.text = "Question ${currentIndex + 1} of ${questions.size}"
    }

    private fun onAnswer(userSaysTrue: Boolean) {
        if (answered) {
            Snackbar.make(btnNext, "You already answered. Tap Next.", Snackbar.LENGTH_SHORT).show()
            return
        }

        answered = true
        btnTrue.isEnabled = false // Disable buttons after answering
        btnFalse.isEnabled = false

        val q = questions[currentIndex]
        if (userSaysTrue == q.correctIsTrue) {
            txtFeedback.text = "Correct!"
            score++
        } else {
            // Updated feedback for a better user experience
            val correctAnswer = if (q.correctIsTrue) "True" else "False"
            txtFeedback.text = "Incorrect. The correct answer was $correctAnswer."
        }
        txtFeedback.visibility = View.VISIBLE
    }

    private fun onNext() {
        if (!answered) {
            Snackbar.make(btnNext, "Please select an answer first.", Snackbar.LENGTH_SHORT).show()
            return
        }

        currentIndex++

        if (currentIndex >= questions.size) {
            // FIX: Navigate to ScoreActivity when the quiz is done
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("total", questions.size)
            startActivity(intent)
            finish() // End this QuestionActivity so the user can't go back to it
        } else {
            // If there are more questions, show the next one
            showQuestion()
        }
    }
}

