package com.example.musical_app

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signin.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        imageView_back.setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }

        reset_pass.setOnClickListener {
            val intent = Intent(this, rename::class.java)
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

            log_in.setOnClickListener{
                val intent = Intent(this, Language::class.java)
                startActivity(intent)
            }

            log_in.setOnClickListener(View.OnClickListener {
                login()
            })
            return false
        }
        return true
    }

    fun login() {
        if (Email1.text.toString().isEmpty() || password1.text.toString().isEmpty()) {
            Toast.makeText(this, "Fields are blank", Toast.LENGTH_LONG).show();
        }

        if (Email1.text.toString() != userinfo.Email && password1.text.toString() != userinfo.Password) {
            Toast.makeText(this, "Check your details ", Toast.LENGTH_LONG).show();
        }

        if (userinfo.Login(Email1.text.toString(), password1.text.toString())) {
            if (Email1.text.toString().isNotEmpty() && password1.text.toString().isNotEmpty()) {

                val intent = Intent(this, Language::class.java)
                startActivity(intent)
            }
        }
    }
}
