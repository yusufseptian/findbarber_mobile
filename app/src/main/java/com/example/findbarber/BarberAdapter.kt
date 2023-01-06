package com.example.findbarber

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class BarberAdapter(private val context: Context, private val barbershop: List<Barbershop>)
    :RecyclerView.Adapter<BarberAdapter.BarbershopViewHolder>(){

    class BarbershopViewHolder(view: View,context: Context):RecyclerView.ViewHolder(view) {
        val imgBarber = view.findViewById<ImageView>(R.id.img_cover)
        val titleBarber = view.findViewById<TextView>(R.id.title_barber)
        val addressBarber = view.findViewById<TextView>(R.id.address_barber)
        val jarakBarber = view.findViewById<TextView>(R.id.jarak_barber)
        val vw = view
        val ct = context


        fun bindview(barbershop: Barbershop){
            imgBarber.setImageResource(barbershop.imgBarber)
            titleBarber.text = barbershop.titleBarber
            addressBarber.text = barbershop.addressBarber
            jarakBarber.text = barbershop.jarakBarber
            vw.setOnClickListener{
                ct.startActivity(Intent(ct,DetailBarberActivity::class.java))
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarbershopViewHolder {
        return BarbershopViewHolder(
            LayoutInflater.from(context).inflate(R.layout.card_barber, parent, false),
            context
        )
    }

    override fun onBindViewHolder(holder: BarbershopViewHolder, position: Int) {
        holder.bindview(barbershop[position])
    }

    override fun getItemCount(): Int = barbershop.size
    }
