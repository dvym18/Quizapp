package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.contentcapture.ContentCaptureSession
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.Constants.getQuestions

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mcurrpos:Int=1
    private var mquestionlist:ArrayList<questions>?=null
    private var mselectedoption:Int=0
    private var musername:String?=null
    private var mcorrectans:Int=0

    private var progressBar:ProgressBar?=null
    private var tvprogress: TextView?=null
    private var tvquestion:TextView?=null
    private var ivImage:ImageView?=null
    private var tv1:TextView?=null
    private var tv2:TextView?=null
    private var tv3:TextView?=null
    private var tv4:TextView?=null

    private var btnsbmit:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        this.actionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
         progressBar=findViewById(R.id.progressbar)
        tvprogress=findViewById(R.id.tv_Progress)
        tvquestion=findViewById(R.id.tv_Question)
        ivImage=findViewById(R.id.iv_Image)
        tv1=findViewById(R.id.option1)
        tv2=findViewById(R.id.option2)
        tv3=findViewById(R.id.option3)
        tv4=findViewById(R.id.option4)
        btnsbmit=findViewById(R.id.btn_submit)
    musername=intent.getStringExtra(Constants.USER_NAME)
        mquestionlist= Constants.getQuestions()
        setquestion()
        tv1?.setOnClickListener(this)
        tv2?.setOnClickListener(this)
        tv3?.setOnClickListener(this)
        tv4?.setOnClickListener(this)
        btnsbmit?.setOnClickListener(this)

    }

    private fun setquestion() {
        defaultoptionview()

        val que: questions = mquestionlist!![mcurrpos - 1]
        progressBar?.progress = mcurrpos
        tvprogress?.text = "${mcurrpos}/${progressBar?.max}"
        ivImage?.setImageResource(que.img)
        tvquestion?.text = que!!.question
        tv1?.text = que.option1
        tv2?.text = que.option2
        tv3?.text = que.option3
        tv4?.text = que.option4

//        if(mcurrpos==mquestionlist!!.size){
//            btnsbmit?.text="FINISH"
//        }
//        else{
//            btnsbmit?.text="NEXT QUESTION"
//        }
    }
        private  fun defaultoptionview(){
            val options=ArrayList<TextView>()
            tv1?.let {
                options.add(0,it)
            }
            tv2?.let {
                options.add(1,it)
            }
            tv3?.let {
                options.add(2,it)
            }

            tv4?.let {
                options.add(3,it)
            }

            for(option in options){
                option.setTextColor(Color.parseColor("#7A8089"))
                option.typeface= Typeface.DEFAULT
                option.background=ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border_bg
                )
            }
            btnsbmit?.text="SUBMIT"
        }
    private fun selectedoptionview(tv:TextView,selectedoptionnum:Int){
            defaultoptionview()
        mselectedoption=selectedoptionnum
     tv.setTextColor(Color.parseColor("#7A8089"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1->{
                tv1?.let{
                    selectedoptionview(it,1)
                }
            }
            R.id.option2->{
                tv2?.let{
                    selectedoptionview(it,2)
                }
            }
            R.id.option3->{
                tv3?.let{
                    selectedoptionview(it,3)
                }
            }
            R.id.option4->{
                tv4?.let{
                    selectedoptionview(it,4)
                }
            }
            R.id.btn_submit-> {
                if (mselectedoption == 0) {
                    mcurrpos++

                when {

                    mcurrpos <= mquestionlist!!.size -> {
                        setquestion()
                    }else->{
                            val intent= Intent(this,ResultActivity::class.java)
                          intent.putExtra(Constants.USER_NAME,musername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mcorrectans)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mquestionlist?.size)
                    startActivity(intent)
                    finish()
                }
                }
            }
            else{
                val que=mquestionlist?.get(mcurrpos-1)
                    if(que!!.correctAns!=mselectedoption) {
                        answerview(mselectedoption, R.drawable.wrong_optionborder_bg)
                    }else{
                        mcorrectans++
                    }
                    answerview(que.correctAns,R.drawable.correct_optionborder_bg)
                    if(mcurrpos==mquestionlist!!.size){
                        btnsbmit?.text="FINISH"
                    }else{
                        btnsbmit?.text="NEXT QUESTION"
                    }
                    mselectedoption=0
                    }

            }
        }
    }

    private fun answerview(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tv1?.background=ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }
            2->{
                tv2?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            3->{
                tv3?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tv4?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }













}