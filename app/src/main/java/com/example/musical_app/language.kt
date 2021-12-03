package com.example.musical_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_language.*

class Language : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        hindi.setOnClickListener{
            val intent  = Intent(this, home::class.java)
            startActivity(intent)
        }

        gujarati.setOnClickListener{
            val intent  = Intent(this, home::class.java)
            startActivity(intent)
        }

        english.setOnClickListener{
            val intent  = Intent(this, home::class.java)
            startActivity(intent)
        }
    }
}