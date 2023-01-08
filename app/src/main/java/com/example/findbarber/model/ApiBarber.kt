package com.example.findbarber.model

data class ApiBarber(
    val b_id: String,
    val b_nama_barber : String,
    val b_nama_pemilik : String,
    val b_foto : String,
    val b_telepon : String,
    val b_provinsi : String,
    val b_kabupaten : String,
    val b_kecamatan : String,
    val b_alamat : String,
    val b_latitude : String,
    val b_longitude : String,
    val b_keterangan : String,
    val created_at : String,
    val updated_at : String,
    val b_user_id : String
)
