package com.example.findbarber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }
    fun regist(v : View){
        startActivity(Intent(this, RegisterActivity::class.java))
    }
    fun login(v : View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}