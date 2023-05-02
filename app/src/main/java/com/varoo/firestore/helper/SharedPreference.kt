package com.varoo.firestore.helper

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.varoo.firestore.model.DataUser

class SharedPreference(activity: Context) {
    val login = "Login"
    val myPref = "Main_Pref"

    val user = "User"
    val sharedPreference: SharedPreferences

    init {
        sharedPreference = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean){
        sharedPreference.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin(b: Boolean):Boolean{
        return sharedPreference.getBoolean(login, false)
    }

    fun setUser(value: DataUser){
        // ubah dari data object ke data string
        val data = Gson().toJson(value, DataUser::class.java)
        sharedPreference.edit().putString(user, data).apply()
    }

    fun getUser(): DataUser? {
        val data = sharedPreference.getString(user, null) ?: return null
            // ubah dari data string ke data object
           return Gson().fromJson<DataUser>(data, DataUser::class.java)

    }
}