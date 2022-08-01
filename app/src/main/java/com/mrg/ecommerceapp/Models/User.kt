package com.mrg.ecommerceapp.Models

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class User(
    var name: String? = "",
    var email: String? = "",
    var img :String? =null
):Serializable {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to name,
            "author" to email,
            "profileImg" to img
        )
    }
}
