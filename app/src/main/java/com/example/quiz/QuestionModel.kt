package com.example.quiz

import android.graphics.drawable.Drawable

data class QuestionModel(
    val id:Int,
    val question:String,
    val image:Int,
    val opone:String,
    val optwo:String,
    val opthree:String,
    val opfour:String,
    val corranswer:Int) {

}