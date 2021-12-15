package com.serglife.movie.data.database

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.serglife.movie.domain.entity.Movie
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DataBaseMovie {
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    suspend fun getFavorites(): List<Movie> {
        return suspendCoroutine { continuation ->

            database = Firebase.database.reference
            auth = Firebase.auth

            database.child(auth.uid.toString()).child("movies")
                .addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {
                        val list = snapshot.children.map {
                            it.getValue(Movie::class.java)
                                ?: throw RuntimeException("Not to convert!!!!!!!!!")
                        }
                        continuation.resume(list)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        continuation.resume(listOf())
                    }

                })
        }
    }
}