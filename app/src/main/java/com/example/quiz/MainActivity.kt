package com.example.quiz

import android.app.Application
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.doAfterTextChanged
import com.example.quiz.QuizActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
var username=""
var music:MediaPlayer= MediaPlayer()
var soundd="on"
class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        music=MediaPlayer.create(this,R.raw.start)
        music.start()
        music.isLooping=true
        val sound=findViewById<ImageButton>(R.id.sound)
        val name=findViewById<EditText>(R.id.editTextTextPersonName)
        val start=findViewById<Button>(R.id.button)
        sound.setOnClickListener{
            if(soundd=="on")
            {
                sound.setImageResource(R.drawable.soundon)
                music.pause()
                soundd="off"
            }
            else {
                sound.setImageResource(R.drawable.soundoff)
                music.start()
                soundd="on"
            }
        }
        name.doAfterTextChanged { start.isEnabled = name.text.isNotEmpty() }
        start.setOnClickListener {
            username=name.text.toString()
            music.stop()
            val intent= Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        if(soundd=="on")
        music.pause()
        super.onPause()
    }

    override fun onResume() {
        if(soundd=="on")
        music.start()
        super.onResume()
    }
}
