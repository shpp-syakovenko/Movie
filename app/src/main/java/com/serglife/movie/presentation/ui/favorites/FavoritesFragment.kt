package com.serglife.movie.presentation.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.serglife.movie.R
import com.serglife.movie.databinding.FragmentFavoritesBinding
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.presentation.ui.favorites.adapter.FavoritesAdapter
import com.serglife.movie.presentation.ui.favorites.adapter.OnClickFavoritesListener
import com.serglife.movie.presentation.ui.movies.adapter.MoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoritesFragment : Fragment(), OnClickFavoritesListener {

    private lateinit var binding: FragmentFavoritesBinding
    private val vm by viewModel<FavoritesViewModel>()
    private lateinit var adapter: FavoritesAdapter

    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFavoritesBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initField()
        getFavorites()

/*        vm.movies.observe(viewLifecycleOwner,{listMovie ->
            adapter.submitList(listMovie)
        })*/
    }

    private fun initField() {
        adapter = FavoritesAdapter()
        adapter.onClickFavoritesListener = this
        binding.rvFavorites.adapter = adapter
    }

    override fun onClick(movie: Movie) {
        findNavController().navigate(FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(movie))
    }

    private fun getFavorites() {
        database = Firebase.database("https://movie-c8b47-default-rtdb.europe-west1.firebasedatabase.app").reference
        auth = Firebase.auth

        val list = mutableListOf<Movie>()

        database.child(auth.uid.toString()).child("movies")
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        val movie = it.getValue(Movie::class.java)
                            ?: throw RuntimeException("Not to convert!!!!!!!!!")

                        list.add(movie)
                    }
                    adapter.submitList(list)
                }
                override fun onCancelled(error: DatabaseError) {}

            })

    }


}