package com.example.assignmentfinal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    // Access questions from the repository
    private val questions = FlashcardRepository.questions

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        // Correctly find views by their ID from the R class
        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtFeedback = findViewById<TextView>(R.id.txtPersonalFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        txtScore.text = "You got $score out of $total correct."

        val percent = if (total == 0) 0 else (score * 100 / total)
        txtFeedback.text = when {
            percent >= 80 -> "Excellent work!"
            percent >= 50 -> "Good — keep practicing!"
            else -> "Keep studying — you'll improve!"
        }

        btnReview.setOnClickListener {
            showReview()
        }

        btnRestart.setOnClickListener {
            // Restart the quiz by navigating back to MainActivity
            val intent = Intent(this, ScoreActivity::class.java)
            startActivity(intent)
            finish() // Close the current ScoreActivity
        }
    }

    private fun showReview() {
        // Build a simple review list programmatically
        val reviewContainer = findViewById<LinearLayout>(/* id = */ R.id.reviewContainer).also {
            it.removeAllViews()
        }
        questions.forEachIndexed { index, q ->
            val tvQ = TextView(this).apply {
                text = "${index + 1}. ${q.question}"
                textSize = 16f
                setPadding(8, 12, 8, 4)
            }
            val tvA = TextView(this).apply {
                val correctAnswer = if (q.correctIsTrue) q.optionTrue else q.optionFalse
                text = "Answer: $correctAnswer"
                setPadding(16, 0, 8, 12)
            }
            reviewContainer.addView(tvQ)
            reviewContainer.addView(tvA)
        }
        // Make sure review area is visible
        val scroll = findViewById<ScrollView>(/* id = */ R.id.reviewScroll)
        scroll.post { scroll.fullScroll(ScrollView.FOCUS_UP) }
    }
}

private fun ERROR.addFlags(intentFlag: Int, intentFlag1: Int) {
    TODO("Not yet implemented")
}

annotation class ERROR
