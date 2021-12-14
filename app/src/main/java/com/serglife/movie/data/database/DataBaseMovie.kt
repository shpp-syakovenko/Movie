package com.serglife.movie.data.database

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.serglife.movie.domain.entity.Movie

class DataBaseMovie {
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    fun getFavorites(): List<Movie> {
        database = Firebase.database("https://movie-c8b47-default-rtdb.europe-west1.firebasedatabase.app").reference
        auth = Firebase.auth

        val list = mutableListOf<Movie>()

        database.child(auth.uid.toString()).child("movies")
            .addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach {
                    val movie = it.getValue(Movie::class.java)
                        ?: throw RuntimeException("Not to convert!!!!!!!!!")
                    list.add(movie)
                }
            }

            override fun onCancelled(error: DatabaseError) {}

        })


        return list

    }
}


