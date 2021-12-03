package com.example.musical_app

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signin.*
import com.google.firebase.auth.FirebaseAuth

import android.widget.ProgressBar

import android.widget.EditText
import com.google.firebase.auth.AuthResult

import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        imageView2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
                val intent = Intent(this, com.example.musical_app.login::class.java)
                startActivity(intent)
            }


        if (IsLogin()) {
            val intent = Intent(this, Language::class.java)
            startActivity(intent)
        }

    }

    fun IsLogin(): Boolean {
        if (!userinfo.userLogin) {
            this.window.apply {
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    statusBarColor = Color.TRANSPARENT
                }
            }

            button_signup.setOnClickListener {
                signup()
            }
            return false
        }
        return true
    }

    fun signup() {
        if (Email.text.toString().isEmpty() || password.text.toString().isEmpty() || name.text.toString().isEmpty()) {
            Toast.makeText(this, "Fields are blank", Toast.LENGTH_LONG).show();
        }
        if (Email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && name.text.toString().isNotEmpty()) {
            userinfo.Email = Email.text.toString()
            userinfo.Password = password.text.toString()
            userinfo.Name = name.text.toString()


            val intent = Intent(this, com.example.musical_app.login::class.java)
            startActivity(intent)
            finish()
        }
    }
}

