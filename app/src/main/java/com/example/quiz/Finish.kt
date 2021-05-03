package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class Finish:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.finish,null)
        val resimg=view.findViewById<ImageView>(R.id.imageView)
        val result=view.findViewById<TextView>(R.id.textView5)
        val restart=view.findViewById<Button>(R.id.res)
        val finish=view.findViewById<Button>(R.id.fin)
        when(points)
        {
            Question.getQuestions().size-> resimg.setImageResource(R.drawable.trophy1)
            Question.getQuestions().size-1->resimg.setImageResource(R.drawable.trophy2)
            Question.getQuestions().size-2->resimg.setImageResource(R.drawable.trophy3)
        }
        result.text="${username}, your score is $points out of ${Question.getQuestions().size}!"
        restart.setOnClickListener {startActivity(Intent(activity,MainActivity::class.java))}
        finish.setOnClickListener { activity?.finishAffinity() }
        return view
    }
}