package com.hfad.cardgame

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

@SuppressLint("StaticFieldLeak")

class Data(context:Context){

    private val sharedpref = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    fun saveData(key:String, value:String){

        with(sharedpref.edit()){
            putString(key, value.toString())
            //putInt(key, value)
            //putInt(key, value)
            apply()
        }
    }


}