package com.mrg.ecommerceapp

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Resoitry {
    val menuListener = object : ValueEventListener {
        override fun onCancelled(databaseError: DatabaseError) {
            // handle error
        }
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            var user = dataSnapshot.getValue(User::class.java)

            var name = user?.name
            var email = user?.email
            var img = user?.img
        }
    }
}