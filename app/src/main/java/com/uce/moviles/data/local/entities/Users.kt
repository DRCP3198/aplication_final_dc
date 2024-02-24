package com.uce.moviles.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    var nombre: String? = "no registrado",
    var email: String? = null,
    var password: String? = null,
    var edad : Int? = 0

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0  // Room will manage this field
}


