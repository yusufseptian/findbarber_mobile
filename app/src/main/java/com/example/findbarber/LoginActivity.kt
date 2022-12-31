package com.example.findbarber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnBackLoginListener()
        btnHomeListener()
    }
    private fun btnBackLoginListener(){
        l_img.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun btnHomeListener(){
        l_btn_1.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}