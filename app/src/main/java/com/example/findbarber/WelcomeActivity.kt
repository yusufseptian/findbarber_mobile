package com.example.findbarber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        btnLoginListener()
        btnRegisterListener()
    }
    private fun btnLoginListener(){
        w_btn_1.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    private fun btnRegisterListener(){
        w_btn_2.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}