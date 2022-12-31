package com.example.findbarber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnBackRegisterListener()

    }
    private fun btnBackRegisterListener(){
        r_img.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}