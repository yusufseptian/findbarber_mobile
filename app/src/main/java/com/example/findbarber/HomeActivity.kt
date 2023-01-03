package com.example.findbarber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomView)
        val navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)

        val barberList = listOf<Barbershop>(
            Barbershop(
                R.drawable.gambar_barber,
                titleBarber = "Adam Barbershop"
            ),

            Barbershop(
                R.drawable.gambar_barber,
                titleBarber = "Hans Barbershop"
            ),

            Barbershop(
                R.drawable.gambar_barber,
                titleBarber = "Evo Barbershop"
            ),

            Barbershop(
                R.drawable.gambar_barber,
                titleBarber = "Alfa Barbershop"
            ),

            Barbershop(
                R.drawable.gambar_barber,
                titleBarber = "Beta Barbershop"
            ),

        )
        val recyclerView = findViewById<RecyclerView>(R.id.barber_show)
        recyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = BarberAdapter(this,barberList)
    }
}