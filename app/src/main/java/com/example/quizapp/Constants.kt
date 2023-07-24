package com.example.quizapp

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"




    fun getQuestions(): ArrayList<questions> {
        val QuestionList=ArrayList<questions>()
        val que1=questions(
            1,"What Country This Flag Belong to?",
            R.drawable.germanyflag,
            "India","Pakistan","Germany","America",
            3
        )
        QuestionList.add(que1)
        val que2=questions(
            2,"What Country This Flag Belong to?",
            R.drawable.argentinaflag,
            "Argentina","Pakistan","Germany","America",
            1
        )
        QuestionList.add(que2)
        val que3=questions(
            3,"What Country This Flag Belong to?",
            R.drawable.pakistanflag,
            "Argentina","Pakistan","Germany","America",
            2
        )
        QuestionList.add(que3)
        val que4=questions(
            4,"What Country This Flag Belong to?",
            R.drawable.indiaflag,
            "Argentina","Pakistan","India","America",
            3
        )
        QuestionList.add(que4)

        val que5=questions(
            5,"What Country This Flag Belong to?",
            R.drawable.americaflag,
            "Argentina","Pakistan","India","America",
            4
        )
        QuestionList.add(que5)


        return QuestionList
    }
}