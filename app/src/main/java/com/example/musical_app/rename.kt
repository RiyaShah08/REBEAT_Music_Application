package com.example.musical_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rename.*

class rename : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rename)

        back_log.setOnClickListener {
            var intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        login_reset.setOnClickListener {
            var intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}