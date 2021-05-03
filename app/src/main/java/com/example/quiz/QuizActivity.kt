package com.example.quiz


import android.app.ActionBar
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.media.AudioManager
import android.media.MediaPlayer
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged

var points=0
class QuizActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        points=Question.getQuestions().size
        var selected=0
        val questionsList=Question.getQuestions()
        var currentPosition=1
        var question:QuestionModel=questionsList[currentPosition-1]
        val progbar=findViewById<ProgressBar>(R.id.progressbar)
        val progtext=findViewById<TextView>(R.id.progress_1)
        val qtext=findViewById<TextView>(R.id.question)
        val img=findViewById<ImageView>(R.id.planets_image)
        val opone=findViewById<TextView>(R.id.option_one)
        val optwo=findViewById<TextView>(R.id.option_two)
        val opthree=findViewById<TextView>(R.id.option_three)
        val opfour=findViewById<TextView>(R.id.option_four)
        val smb=findViewById<Button>(R.id.submit)
        progbar.progress=currentPosition
        progtext.text="${currentPosition}/${progbar.max}"
        qtext.text=question.question
        img.setImageResource(question.image)
        opone.text=question.opone
        optwo.text=question.optwo
        opthree.text=question.opthree
        opfour.text=question.opfour
        opone.setOnClickListener {
            if(smb.text=="Submit")
            when(selected) {
                0->{
                    opone.setBackgroundResource(R.drawable.selected_bg)
                    selected=1}
                1->{
                    opone.setBackgroundResource(R.drawable.default_bg)
                    selected=0}
                2->{
                    optwo.setBackgroundResource(R.drawable.default_bg)
                    opone.setBackgroundResource(R.drawable.selected_bg)
                    selected=1}
                3->{
                    opthree.setBackgroundResource(R.drawable.default_bg)
                    opone.setBackgroundResource(R.drawable.selected_bg)
                    selected=1}
                4->{
                    opfour.setBackgroundResource(R.drawable.default_bg)
                    opone.setBackgroundResource(R.drawable.selected_bg)
                    selected=1}
            }
        }
        optwo.setOnClickListener {
            if(smb.text=="Submit")
            when(selected) {
                0->{
                    optwo.setBackgroundResource(R.drawable.selected_bg)
                    selected=2}
                1->{
                    opone.setBackgroundResource(R.drawable.default_bg)
                    optwo.setBackgroundResource(R.drawable.selected_bg)
                    selected=2}
                2->{
                    optwo.setBackgroundResource(R.drawable.default_bg)
                    selected=0}
                3->{
                    opthree.setBackgroundResource(R.drawable.default_bg)
                    optwo.setBackgroundResource(R.drawable.selected_bg)
                    selected=2}
                4->{
                    opfour.setBackgroundResource(R.drawable.default_bg)
                    optwo.setBackgroundResource(R.drawable.selected_bg)
                    selected=2}
            }
        }
        opthree.setOnClickListener {
            if(smb.text=="Submit")
            when(selected) {
                0->{
                    opthree.setBackgroundResource(R.drawable.selected_bg)
                    selected=3}
                1->{
                    opone.setBackgroundResource(R.drawable.default_bg)
                    opthree.setBackgroundResource(R.drawable.selected_bg)
                    selected=3}
                2->{
                    optwo.setBackgroundResource(R.drawable.default_bg)
                    opthree.setBackgroundResource(R.drawable.selected_bg)
                    selected=3}
                3->{
                    opthree.setBackgroundResource(R.drawable.default_bg)
                    selected=0}
                4->{
                    opfour.setBackgroundResource(R.drawable.default_bg)
                    opthree.setBackgroundResource(R.drawable.selected_bg)
                    selected=3}
            }
        }
        opfour.setOnClickListener {
            if(smb.text=="Submit")
            when(selected) {
                0->{
                    opfour.setBackgroundResource(R.drawable.selected_bg)
                    selected=4}
                1->{
                    opone.setBackgroundResource(R.drawable.default_bg)
                    opfour.setBackgroundResource(R.drawable.selected_bg)
                    selected=4}
                2->{
                    optwo.setBackgroundResource(R.drawable.default_bg)
                    opfour.setBackgroundResource(R.drawable.selected_bg)
                    selected=4}
                3->{
                    opthree.setBackgroundResource(R.drawable.default_bg)
                    opfour.setBackgroundResource(R.drawable.selected_bg)
                    selected=4}
                4->{
                    opfour.setBackgroundResource(R.drawable.default_bg)
                    selected=0}
            }
        }
        smb.setOnClickListener {
            if(smb.text=="Submit") {
                if (selected != 0) {
                    when (question.corranswer) {
                        1 -> opone.setBackgroundColor(Color.GREEN)
                        2 -> optwo.setBackgroundColor(Color.GREEN)
                        3 -> opthree.setBackgroundColor(Color.GREEN)
                        4 -> opfour.setBackgroundColor(Color.GREEN)
                    }
                    if(currentPosition==Question.getQuestions().size)
                        smb.text="Finish"
                    else
                    smb.text="Next"
                }
                if (selected != question.corranswer) {
                    points--
                    when (selected) {
                        0 -> {Toast.makeText(applicationContext, "Please select one option", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener}
                        1 -> opone.setBackgroundColor(Color.RED)
                        2 -> optwo.setBackgroundColor(Color.RED)
                        3 -> opthree.setBackgroundColor(Color.RED)
                        4 -> opfour.setBackgroundColor(Color.RED)
                    }
                    MediaPlayer.create(this,R.raw.wrong).start()
                }
                else MediaPlayer.create(this,R.raw.right).start()
            }
            else if(smb.text=="Next"){
                currentPosition++
                question=questionsList[currentPosition-1]
                progbar.progress=currentPosition
                progtext.text="${currentPosition}/${progbar.max}"
                qtext.text=question.question
                img.setImageResource(question.image)
                opone.text=question.opone
                optwo.text=question.optwo
                opthree.text=question.opthree
                opfour.text=question.opfour
                opone.setBackgroundResource(R.drawable.default_bg)
                optwo.setBackgroundResource(R.drawable.default_bg)
                opthree.setBackgroundResource(R.drawable.default_bg)
                opfour.setBackgroundResource(R.drawable.default_bg)
                selected=0
                smb.text="Submit"}
            else
                {
                    val fragment=Finish()
                    val transaction=supportFragmentManager.beginTransaction()
                    val linearLayout=findViewById<LinearLayout>(R.id.linear)
                    linearLayout.visibility=View.GONE
                    transaction.add(R.id.frame,fragment)
                    transaction.commit()
                    MediaPlayer.create(this,R.raw.end).start()
                }
            }
        }
    override fun onBackPressed() {
        val exit=Dialog()
        exit.show(supportFragmentManager,"dialog")
    }
}