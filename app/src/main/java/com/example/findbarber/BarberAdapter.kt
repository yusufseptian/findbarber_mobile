package com.example.findbarber

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BarberAdapter(private val context: Context, private val barbershop: List<Barbershop>)
    :RecyclerView.Adapter<BarberAdapter.BarbershopViewHolder>(){

    class BarbershopViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imgBarber = view.findViewById<ImageView>(R.id.img_cover)
        val titleBarber = view.findViewById<TextView>(R.id.title_barber)
        val vw = view

        fun bindview(barbershop: Barbershop){
            imgBarber.setImageResource(barbershop.imgBarber)
            titleBarber.text = barbershop.titleBarber

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarbershopViewHolder {
        return BarbershopViewHolder(
            LayoutInflater.from(context).inflate(R.layout.card_barber, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BarbershopViewHolder, position: Int) {
        holder.bindview(barbershop[position])
    }

    override fun getItemCount(): Int = barbershop.size
    }
