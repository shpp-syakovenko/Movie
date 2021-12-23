package com.serglife.movie.presentation.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.serglife.movie.data.database.AUTH
import com.serglife.movie.databinding.FragmentFavoritesBinding
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.presentation.ui.favorites.adapter.FavoritesAdapter
import com.serglife.movie.presentation.ui.favorites.adapter.OnClickFavoritesListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoritesFragment : Fragment(), OnClickFavoritesListener {

    private lateinit var binding: FragmentFavoritesBinding
    private val vm by viewModel<FavoritesViewModel>()
    private lateinit var adapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFavoritesBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initField()

        AUTH.currentUser?.let {
            vm.updateFavorites()
            vm.movies.observe(viewLifecycleOwner, { listMovie ->
                adapter.submitList(listMovie)
            })
        }
    }

    private fun initField() {
        adapter = FavoritesAdapter()
        adapter.onClickFavoritesListener = this
        binding.rvFavorites.adapter = adapter
    }

    override fun onClick(movie: Movie) {
        findNavController().navigate(
            FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(
                movie
            )
        )
    }
}