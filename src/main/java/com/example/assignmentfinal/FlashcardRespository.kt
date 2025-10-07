package com.example.assignmentfinal

object FlashcardRepository {
    val questions = listOf(Flashcard("The capital of France is Paris.", "True", "False", true),
        Flashcard("Water boils at 90 degrees Celsius.", "True", "False", false),
        Flashcard("The Great Wall of China is visible from space.", "True", "False", false),
        Flashcard("Mount Everest is the tallest mountain in the world.", "True", "False", true)
        // Add more questions here
    )
}
