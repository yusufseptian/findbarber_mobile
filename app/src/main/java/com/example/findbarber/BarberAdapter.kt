package com.example.findbarber

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class BarberAdapter(private val context: Context, private val barbershop: List<Barbershop>, val listener: (Barbershop) -> Unit)
    :RecyclerView.Adapter<BarberAdapter.BarbershopViewHolder>(){
    class BarbershopViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imgBarber = view.findViewById<ImageView>(R.id.img_cover)
        val titleBarber = view.findViewById<ImageView>(R.id.title_barber)

        fun bindview(barbershop: Barbershop, listener: (Barbershop) -> Unit){
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
        holder.bindview(barbershop[position],listener)
    }

    override fun getItemCount(): Int = barbershop.size
    }
