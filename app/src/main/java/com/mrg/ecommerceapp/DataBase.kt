package com.mrg.ecommerceapp

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DataBase {
    companion object{
        @Volatile
        private var database : DatabaseReference? = null
        fun getFbDataBase(context: Context) : DatabaseReference {
            return database ?: synchronized(this) {
                val instance =  Firebase.database.reference
                database = instance
                Log.d(ContentValues.TAG, "getFbDataBase: ${database}")
                return database as DatabaseReference
                //instance
            }
        }

    }
}