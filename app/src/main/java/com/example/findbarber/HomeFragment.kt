package com.example.findbarber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val recyclerView = v.findViewById<RecyclerView>(R.id.homeFragment)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = BarberAdapter(v.context,barberList)
        return v
    }


}