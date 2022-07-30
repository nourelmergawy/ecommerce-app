package com.mrg.ecommerceapp

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var name: String? = "",
    var email: String? = "",
    var img :Int? =null
) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to name,
            "author" to email,
            "profileImg" to img
        )
    }
}
