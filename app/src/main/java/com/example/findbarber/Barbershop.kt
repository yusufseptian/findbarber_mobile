package com.example.findbarber

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Barbershop(
    val imgBarber: Int,
    val titleBarber: String,
    val addressBarber: String,
) : Parcelable
