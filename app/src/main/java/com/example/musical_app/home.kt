package com.example.musical_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        image1.setOnClickListener {
            val intent = Intent(this, song_main::class.java)
            startActivity(intent)
        }

        image2.setOnClickListener {
            val intent = Intent(this, song_main2::class.java)
            startActivity(intent)
        }

        image3.setOnClickListener {
            val intent = Intent(this, song_main3::class.java)
            startActivity(intent)
        }

        image7.setOnClickListener {
            val intent = Intent(this, playlists::class.java)
            startActivity(intent)
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }

        val OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.playlist -> {
                    val intent = Intent(this, savedframe::class.java)
                    startActivity(intent)
                }
            }
            return@OnNavigationItemSelectedListener true
        }

}