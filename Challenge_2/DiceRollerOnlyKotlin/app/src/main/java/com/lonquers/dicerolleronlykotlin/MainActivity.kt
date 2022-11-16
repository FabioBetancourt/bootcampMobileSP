package com.lonquers.dicerolleronlykotlin

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick: Button = findViewById(R.id.button)

        buttonClick.setOnClickListener{
            timer()
            val sound = MediaPlayer.create(this, R.raw.dice_sound)
            sound.start()
        }
    }

    private fun diceWithButtonAndImage() {

        var result = (1..6).random()
        val imageDice: ImageView = findViewById(R.id.imageView)
        when (result) { //conditional for each case
            1 -> imageDice.setImageResource(R.drawable.dice_1)
            2 -> imageDice.setImageResource(R.drawable.dice_2)
            3 -> imageDice.setImageResource(R.drawable.dice_3)
            4 -> imageDice.setImageResource(R.drawable.dice_4)
            5 -> imageDice.setImageResource(R.drawable.dice_5)
            else -> imageDice.setImageResource(R.drawable.dice_6)
        }
    }

    private fun timer(){
        object : CountDownTimer(2000, 100) {
            override fun onTick(p0: Long) {
                diceWithButtonAndImage()
            }
            override fun onFinish() {
            }
        }.start()
    }
}
