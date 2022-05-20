package com.example.musical_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_playlists.*

class playlists : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlists)

        undo_play.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        linearLayout6.setOnClickListener {
            val intent = Intent(this, song_playlist::class.java)
            startActivity(intent)
        }

        linearLayout8.setOnClickListener {
            val intent = Intent(this, song_playlist1::class.java)
            startActivity(intent)
        }

        var like = findViewById(R.id.mainheart) as ImageView

        like.setOnClickListener {
            if (!like.isActivated) {
                like.setBackgroundResource(R.drawable.lifefull)
            }

            else {
                like.setBackgroundResource(R.drawable.lifeempty)
            }
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }

    val OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.playlist -> {
                    val intent = Intent(this, savedframe::class.java)
                    startActivity(intent)
                }

                R.id.home -> {
                    val intent = Intent(this, home::class.java)
                    startActivity(intent)
                }

            }
            return@OnNavigationItemSelectedListener true
        }
}