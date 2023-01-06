package com.example.findbarber

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_home, container, false)
        val barberList = listOf<Barbershop>(
            Barbershop(
                R.drawable.gambar_barber,
                titleBarber = "Adam Barbershop",
                addressBarber ="Jl.Magelang Km 50",
                jarakBarber = "14 Km"),
            Barbershop(
                R.drawable.gambar_barber1,
                titleBarber = "Hans Barbershop",
                addressBarber ="Jl.Magelang Km 50",
                jarakBarber = "3 Km"),
            Barbershop(
                R.drawable.gambar_barber2,
                titleBarber = "Evo Barbershop",
                addressBarber ="Jl.Magelang Km 50",
                jarakBarber = "6 Km"),
            Barbershop(
                R.drawable.gambar_barber3,
                titleBarber = "Alfa Barbershop",
                addressBarber ="Jl.Magelang Km 50",
                jarakBarber = "8 Km"),
            Barbershop(
                R.drawable.gambar_barber4,
                titleBarber = "Beta Barbershop",
                addressBarber ="Jl.Magelang Km 50",
                jarakBarber = "2 Km"
            ),
        )
        val recyclerView = v.findViewById<RecyclerView>(R.id.homeFragment)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = BarberAdapter(v.context,barberList)
        v.findViewById<Button>(R.id.maps).setOnClickListener{
            startActivity(Intent(context, MapsActivity::class.java))
        }
        return v
    }
}