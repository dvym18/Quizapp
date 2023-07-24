package com.example.quizapp

data class questions(
    val id:Int,
    val question:String,
    val img:Int,
    val option1:String,
    val option2:String,
    val option3:String,
    val option4:String,
    val correctAns:Int,
)
