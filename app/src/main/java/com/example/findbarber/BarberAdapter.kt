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
import com.bumptech.glide.Glide
import com.example.findbarber.model.ApiBarber
import com.example.findbarber.repository.Repository

class BarberAdapter(private val context: Context, private val barbershop: List<ApiBarber>)
    :RecyclerView.Adapter<BarberAdapter.BarbershopViewHolder>(){

    inner class BarbershopViewHolder(view: View,context: Context):RecyclerView.ViewHolder(view) {
        val imgBarber = view.findViewById<ImageView>(R.id.img_cover)
        val titleBarber = view.findViewById<TextView>(R.id.title_barber)
        val addressBarber = view.findViewById<TextView>(R.id.address_barber)
        val vw = view
        val ct = context


        fun bindview(barbershop: ApiBarber){
            Glide.with(ct).load(Repository.baseUrl+"foto_barber/"+barbershop.b_foto).centerCrop().into(imgBarber)
//            imgBarber.setImageResource(R.drawable.gambar_barber)
            titleBarber.text = barbershop.b_nama_barber
            addressBarber.text = barbershop.b_alamat
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
