package com.serglife.movie.data.database


import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.serglife.movie.domain.entity.Movie
import kotlinx.coroutines.flow.MutableSharedFlow

class DataBaseMovie {

    val movies = MutableSharedFlow<List<Movie>>(1, 10)


    fun listenMovies() {
        REF_DATABASE_ROOT.child(AUTH.uid.toString()).child(NODE_MOVIES)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = snapshot.children.map {
                        it.getValue(Movie::class.java)
                            ?: throw RuntimeException("Not to convert!!!!!!!!!")
                    }
                    movies.tryEmit(list)
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    fun deleteFavorites(fMovie: Movie) {

        var key: String? = null

        REF_DATABASE_ROOT.child(AUTH.uid.toString()).child(NODE_MOVIES)
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        val movie = it.getValue(Movie::class.java)
                            ?: throw RuntimeException("Not to convert!!!!!!!!!")
                        if (fMovie.id == movie.id) {
                            key = it.key
                        }
                    }
                    key?.let {
                        REF_DATABASE_ROOT.child(AUTH.uid.toString()).child(NODE_MOVIES).child(it)
                            .removeValue()
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    fun addFavorites(movie: Movie) {

        var isItMovie = false

        REF_DATABASE_ROOT.child(AUTH.uid.toString()).child(NODE_MOVIES)
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        val movieBd = it.getValue(Movie::class.java)
                            ?: throw RuntimeException("Not to convert!!!!!!!!!")
                        isItMovie = movie.id == movieBd.id
                    }
                    if (!isItMovie) {
                        AUTH.currentUser?.uid?.let {
                            REF_DATABASE_ROOT.child(AUTH.uid.toString()).child(NODE_MOVIES).push()
                                .setValue(movie)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })

    }
}