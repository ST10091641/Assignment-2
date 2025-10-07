package com.example.assignmentfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class activity_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // FIX: This line connects your activity to its XML layout file.
        // This is the most likely cause of the blank screen.
        setContentView(R.layout.activity_main)

        // Find the "Start Quiz" button from your layout
        val btnStartQuiz = findViewById<Button>(R.id.btnStartQuiz)

        // Set a listener to handle the button click
        btnStartQuiz.setOnClickListener {
            // Create an Intent to start QuestionActivity
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}
