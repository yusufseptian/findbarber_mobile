package com.example.findbarber

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.findbarber.helper.SessionManager
import com.example.findbarber.model.ApiBarber
import com.example.findbarber.repository.Repository
import okhttp3.internal.notify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var sessionManager: SessionManager
    private lateinit var dt_barber : List<ApiBarber>
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapters: BarberAdapter
            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_home, container, false)
        v.findViewById<EditText>(R.id.b_search).setOnKeyListener(View.OnKeyListener{
            v,keyCode,event->if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
            if (!v.findViewById<EditText>(R.id.b_search).text.toString().trim().isEmpty()){
                Repository.ApiBarber().searchBarber(v.findViewById<EditText>(R.id.b_search).
                text.toString()).enqueue(object : Callback<List<ApiBarber>>{
                    override fun onResponse(
                        call: Call<List<ApiBarber>>,
                        response: Response<List<ApiBarber>>
                    ) {
                        if (response.isSuccessful){
                            dt_barber = response.body()!!
                            adapters.notifyDataSetChanged()
                            Toast.makeText(v.context,"Ok",Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(v.context,"error : " + response.code()+response.message(),Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<List<ApiBarber>>, t: Throwable) {
                        Toast.makeText(v.context,"error : " +t.message,Toast.LENGTH_LONG).show()                    }
                })
            }
            return@OnKeyListener true
        }
            false

        })
        Repository.ApiBarber().findAll().enqueue(object : Callback<List<ApiBarber>>{
            override fun onResponse(
                call: Call<List<ApiBarber>>,
                response: Response<List<ApiBarber>>
            ) {
                if (response.isSuccessful){
                    dt_barber = response.body()!!
                    adapters = BarberAdapter(v.context,dt_barber)
                    recyclerView = v.findViewById(R.id.homeFragment)
                    recyclerView.layoutManager = LinearLayoutManager(v.context)
                    recyclerView.setHasFixedSize(true)
                    recyclerView.adapter = adapters
                    Toast.makeText(v.context,"Ok",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(v.context,"error : " + response.code()+response.message(),Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<ApiBarber>>, t: Throwable) {
                Toast.makeText(v.context,"error : " +t.message,Toast.LENGTH_LONG).show()
            }

        })
        val barberList = listOf<Barbershop>(
            Barbershop(
                R.drawable.gambar_barber,
                titleBarber = "Adam Barbershop",
                addressBarber ="Jl.Magelang Km 50"),
            Barbershop(
                R.drawable.gambar_barber1,
                titleBarber = "Hans Barbershop",
                addressBarber ="Jl.Magelang Km 50"),
            Barbershop(
                R.drawable.gambar_barber2,
                titleBarber = "Evo Barbershop",
                addressBarber ="Jl.Magelang Km 50"),
            Barbershop(
                R.drawable.gambar_barber3,
                titleBarber = "Alfa Barbershop",
                addressBarber ="Jl.Magelang Km 50"),
            Barbershop(
                R.drawable.gambar_barber4,
                titleBarber = "Beta Barbershop",
                addressBarber ="Jl.Magelang Km 50",
            ),
        )

        v.findViewById<Button>(R.id.maps).setOnClickListener{
            startActivity(Intent(context, MapsActivity::class.java))
        }
        sessionManager = SessionManager(v.context, "login")
        v.findViewById<TextView>(R.id.h_txt2).text = sessionManager.get("nama")
        return v
    }
}