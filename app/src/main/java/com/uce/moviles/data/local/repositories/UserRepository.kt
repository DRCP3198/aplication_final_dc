package com.uce.moviles.data.local.repositories

import com.uce.moviles.data.local.entities.Users

class UserRepository {

    fun getUserList(): List<Users> {
        return listOf<Users>(
            Users(
                "dil", "dil", "123",
                15
            ),

        )
    }
}