Khaya Nkambule ST10091641 IMAD5112 Assignment 2  

1. Introduction 

The Flashcard Study App is a native Android application developed using Kotlin in Android Studio. 
Its primary purpose is to help learners revise and test their knowledge on various subjects—such as Mathematics, History, or General Knowledge—through an interactive flashcard-based quiz. 

The app allows users to: 

View flashcard-style questions 

Choose answers (True/False) 

Receive immediate feedback 

View a final score 

Review all questions and correct answers at the end 

The application also integrates with GitHub for version control and uses GitHub Actions to automate build and test processes, ensuring continuous integration and deployment readiness. 

 

2. Purpose of the Application 

2.1 Educational Objective 

The Flashcard App aims to provide an engaging self-assessment tool for learners. It simulates a digital version of traditional flashcards, allowing users to test and reinforce their understanding of concepts. 

2.2 Technical Objective 

From a software engineering perspective, the app serves to: 

Demonstrate proficiency in Kotlin programming 

Showcase the ability to design and build native Android applications 

Implement modular architecture and clean UI design principles 

Integrate GitHub and GitHub Actions for version control and CI/CD automation 

 

3. System Design and Architecture 

3.1 App Architecture Overview 

The app follows a three-activity structure: 

MainActivity (Welcome Screen) – Provides the introduction and a “Start” button. 

QuestionActivity (Flashcard Screen) – Displays questions, answer buttons, and feedback. 

ScoreActivity (Results Screen) – Shows the total score, personalized feedback, and a review of correct answers. 

3.2 Data Model 

A Flashcard data class is used to store each question: 

data class Flashcard( 
   val question: String, 
   val optionTrue: String = "True", 
   val optionFalse: String = "False", 
   val correctIsTrue: Boolean 
) 
 

This model enables easy scalability — more questions or categories can be added without structural changes. 

3.3 Data Source 

All flashcard questions are defined in a repository object (FlashcardRepository) to centralize question management. This approach supports future integration with databases or APIs. 

 

4. User Interface (UI) Design Considerations 

4.1 Simplicity and Accessibility 

The design focuses on clarity and usability: 

Large buttons for answer selection 

Readable font sizes 

Minimal color distractions 

Responsive layout that adjusts across screen sizes 

4.2 Screen Flow 

Welcome Screen 

Displays the app description 

“Start” button navigates to the question screen 

Flashcard Question Screen 

Displays a question and two answer buttons (True/False) 

Provides immediate feedback (“Correct!” or “Try Again!”) 

Includes a “Next” button to progress 

Score Screen 

Displays the total score and performance feedback 

“Review” button lists all questions with correct answers 

“Restart” button returns to the welcome screen 

4.3 Visual Design 

Layouts created with ConstraintLayout and LinearLayout 

Consistent padding and margins to ensure spacing balance 

Neutral colors and standard Material components for a clean UI 

 

5. Application Logic 

5.1 Welcome Screen Logic 

On pressing “Start,” the user is redirected to QuestionActivity using an Intent. 

5.2 Flashcard Question Logic 

A loop iterates through all flashcard questions. 

Each question waits for user input (True/False). 

Immediate feedback is displayed based on correctness. 

The score counter increments for correct answers. 

At the end of the list, results are passed to the ScoreActivity. 

5.3 Score Screen Logic 

Displays the total number of correct answers. 

Provides personalized messages: 

Excellent work! (≥80%) 

Good — keep practicing! (≥50%) 

Keep studying — you'll improve! (<50%) 

“Review” shows all flashcards with correct answers. 

“Restart” restarts the quiz from the beginning. 

 

6. GitHub Utilisation 

6.1 Purpose 

GitHub is used as the Version Control System (VCS) for managing the source code. 
It allows for collaboration, history tracking, and backup of the codebase. 

6.2 Key GitHub Practices Implemented 

Repository Setup 

A GitHub repository named FlashcardApp-Kotlin was created. 

.gitignore configured to exclude build/ and .idea/ files. 

Version Control Workflow 

Code changes are committed with descriptive messages (e.g., “Added ScoreActivity logic”). 

Branches are used for feature development (feature-ui, feature-logic). 

Merges to the main branch occur after code reviews. 

Collaboration 

Team members can clone, pull, and push updates. 

Issues and Pull Requests help manage progress and bug tracking. 

Documentation 

A README.md file provides setup instructions, app features, and screenshots. 

 

7. GitHub Actions Integration 

7.1 Purpose 

GitHub Actions automates build, testing, and deployment tasks. 
It provides Continuous Integration (CI) — ensuring that every push to GitHub is automatically checked for errors. 

7.2 Configuration Overview 

A workflow YAML file (.github/workflows/android-ci.yml) is added to the repository: 

name: Android CI 
 
on: 
 push: 
   branches: [ "main" ] 
 pull_request: 
   branches: [ "main" ] 
 
jobs: 
 build: 
   runs-on: ubuntu-latest 
 
   steps: 
   - name: Checkout code 
     uses: actions/checkout@v3 
 
   - name: Set up JDK 17 
     uses: actions/setup-java@v3 
     with: 
       java-version: '17' 
       distribution: 'temurin' 
 
   - name: Build with Gradle 
     run: ./gradlew build 
 

7.3 Workflow Explanation 

Trigger: Runs automatically when code is pushed or a pull request is opened. 

Build Job: 

Checks out the project code. 

Installs the required Java version (JDK 17). 

Runs Gradle to build and verify the project. 

Outcome: 

Ensures every code update compiles successfully. 

Detects build errors before merging to main. 

Provides automatic feedback in GitHub Pull Requests. 

 

8. Testing and Validation 

8.1 Manual Testing 

Verified that the app navigates between all screens correctly. 

Tested “True/False” answers and ensured score tracking works. 

Checked that feedback displays immediately after each answer. 

Confirmed that restarting the quiz resets progress. 

8.2 Automated Testing (Optional) 

Basic unit tests can be added for score calculation logic and activity transitions. 

 

9. Challenges and Solutions 

Challenge, Solution 

Managing activity transitions, Implemented explicit Intent calls between activities. 

Preventing next question before answering, Added checks to ensure feedback is shown first. 

Layout inconsistencies on small screens, Used ConstraintLayout for adaptive resizing. 

GitHub Actions build errors, Added ./gradlew build and JDK setup steps in YAML file. 

 

10. Future Enhancements 

Add multiple-choice questions. 

Include categories (Math, History, Science). 

Store progress using Room Database or SharedPreferences. 

Add sound effects or animations for correct/incorrect answers. 

Use Firebase for cloud-based question storage. 

 

11. Conclusion 

The Flashcard App successfully demonstrates: 

The use of Kotlin for native Android development 

Application of clean UI/UX design principles 

Implementation of modular app logic for quizzes 

Proper integration with GitHub for version control 

Utilization of GitHub Actions for continuous integration 

This project effectively combines educational functionality with software engineering best practices, making it a robust example of Android app development and DevOps automation. 

 

12. References 

Android Developers Documentation: https://developer.android.com 

Kotlin Language Reference: https://kotlinlang.org/docs/home.html 

GitHub Actions Documentation: https://docs.github.com/en/actions 

https://github.com/ST10091641/Assignment-2 

Android Developers, 2024. Build your first app. [online] Available at: https://developer.android.com/training/basics/firstapp [Accessed 5 October 2025]. 

Android Developers, 2024. Layouts and views overview. [online] Available at: https://developer.android.com/guide/topics/ui/declaring-layout [Accessed 5 October 2025]. 

GitHub Docs, 2024. Understanding GitHub Actions. [online] GitHub. Available at: https://docs.github.com/en/actions/learn-github-actions [Accessed 6 October 2025]. 

Kotlin Foundation, 2024. Kotlin language documentation. [online] Available at: https://kotlinlang.org/docs/home.html [Accessed 6 October 2025]. 

Google Developers, 2024. Intent and navigation in Android. [online] Available at: https://developer.android.com/guide/components/intents-filters [Accessed 7 October 2025]. 

JetBrains, 2024. Kotlin for Android Developers. [online] Available at: https://developer.jetbrains.com/kotlin/android/ [Accessed 7 October 2025]. 

 
