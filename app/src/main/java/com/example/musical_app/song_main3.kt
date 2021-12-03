package com.example.musical_app

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_song_playlist1.*

class song_main3 : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_main3)

        back_down.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.zaalimacocacola)

        var btnplay = findViewById(R.id.btn_play2)as Button

        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        seekbar.progress=0
        seekbar.max = mediaPlayer.duration

        btnplay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                btnplay.setBackgroundResource(R.drawable.pause)
            }

            else{
                mediaPlayer.pause()
                btnplay.setBackgroundResource(R.drawable.circle)
            }
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if (changed){
                    mediaPlayer.seekTo(pos)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        runnable =Runnable{
            seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }

        handler.postDelayed(runnable,1000)

        mediaPlayer.setOnCompletionListener {
            btnplay.setBackgroundResource(R.drawable.circle)
            seekbar.progress=0
        }

        var like = findViewById(R.id.imageview13) as ImageView

        like.setOnClickListener {
            if (!like.isActivated) {
                like.setBackgroundResource(R.drawable.lifefull)
            }

            else {
                like.setBackgroundResource(R.drawable.lifeempty)
            }
        }
    }
}
