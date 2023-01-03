package com.example.findbarber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWelcomeListener()
    }
    private fun btnWelcomeListener()
    {
//        btn_1.setOnClickListener{
//            startActivity(Intent(this, WelcomeActivity::class.java))
//        }
    }

    fun toWelcome(v : View){
        startActivity(Intent(this, WelcomeActivity::class.java))
    }


}