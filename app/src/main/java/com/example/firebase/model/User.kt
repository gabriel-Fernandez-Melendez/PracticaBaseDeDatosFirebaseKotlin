package com.example.firebase.model

data class User (
        val userId: String,
        val email: String,
        val username: String,
    ){
        fun toMap(): MutableMap<String, Any>{
            return mutableMapOf(
                "userId" to this.userId,
                "email" to this.email,
                "username" to this.username,
            )
        }
    }

