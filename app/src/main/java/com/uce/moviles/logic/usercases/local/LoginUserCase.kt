package com.uce.moviles.logic.usercases.local

import android.util.Log
import com.uce.moviles.data.local.entities.Users
import com.uce.moviles.data.local.repositories.DBRepository
import com.uce.moviles.data.local.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginUserCase(val connection: DBRepository) {

    suspend fun checkLogin(username: String, password: String): Int {
        var ret = -1

// Ejecuta la operación getAllUser en el hilo de entrada/salida (Dispatchers.IO)
        val users = withContext(Dispatchers.IO) {
            getAllUser()

        }
        Log.d("USER", users.get(5).toString() )
        val lstUsers = users.filter { it.email ==username  && it.password == password }

        if (lstUsers.isNotEmpty()) {
            ret = lstUsers.first().id
        }

// Loguea el resultado
        Log.d("NOMBRE", ret.toString())

        return ret  // Devuelve el resultado de la función
    }

//    suspend fun getUserName(userId: Int): Users =
//        connection.getUsersDAO().getOneUser(userId)
//
//    suspend fun insertUsers() =
//        if (connection.getUsersDAO().getAllUsers().isEmpty()) {
//            connection.getUsersDAO().insertUser(
//                UserRepository().getUserList()
//            )
//        } else {
//            null
//        }
//
//    suspend fun getAllUsers(): List<Users> =
//        connection.getUsersDAO().getAllUsers()
    suspend fun insertSingleUser(user: Users){
        connection.getUserDAO().insertSingleUser(user)

    }
    suspend fun insertUsers(){

        if(connection.getUserDAO().getAllUsers().isEmpty()){
            connection.getUserDAO().insertUser(UserRepository().getUserList())
        }else{

        }

    }
    suspend fun getAllUser():  List<Users>{
        return connection.getUserDAO().getAllUsers()

    }
}