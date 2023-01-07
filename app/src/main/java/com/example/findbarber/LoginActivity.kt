package com.example.findbarber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.findbarber.`interface`.Auth
import com.example.findbarber.helper.SessionManager
import com.example.findbarber.model.Login
import com.example.findbarber.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sessionManager = SessionManager(this, "login")
    }

    fun back(v : View){
        finish()
    }
    fun login(v : View){
//        startActivity(Intent(this, HomeActivity::class.java))
        Repository.auth().login(
            findViewById<EditText>(R.id.l_username).text.toString(),
            findViewById<EditText>(R.id.l_password).text.toString()
        ).enqueue(object : Callback<Login>{
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if (response.isSuccessful){
                    if (response.body()!!.success){
                        sessionManager.set("nama", response.body()!!.du_nama)
                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                    } else {
                        Toast.makeText(this@LoginActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Gagal load data", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Login>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error: " + t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}