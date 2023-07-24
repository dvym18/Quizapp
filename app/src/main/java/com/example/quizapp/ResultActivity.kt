package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.actionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username: TextView =findViewById(R.id.tv_name)
        val score:TextView=findViewById(R.id.tv_score)
        val btn: Button =findViewById(R.id.btnfinsh)
        username.text=intent.getStringExtra(Constants.USER_NAME)
        val totalquestion=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val corrans=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        score.text="Your Score is $corrans Out of $totalquestion"
        btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}