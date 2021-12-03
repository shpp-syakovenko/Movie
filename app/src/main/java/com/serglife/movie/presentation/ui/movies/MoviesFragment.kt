package com.serglife.movie.presentation.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.serglife.movie.databinding.FragmentMoviesBinding
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.presentation.common.views.ScrollMoreListener
import com.serglife.movie.presentation.ui.movies.adapter.MoviesAdapter
import com.serglife.movie.presentation.ui.movies.adapter.OnClickMovieListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesFragment : Fragment(), OnClickMovieListener {

    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapter: MoviesAdapter
    private val vm: MoviesViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMoviesBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initField()

        vm.movies.observe(viewLifecycleOwner, { movies ->
            adapter.submitList(movies)
        })

        binding.rvMovies.addOnScrollListener(
            ScrollMoreListener(ScrollMoreListener.SCROLL_DIRECTION_BOTTOM) {
                vm.load()
            })
    }

    private fun initField() {
        adapter = MoviesAdapter()
        adapter.onClickMovieListener = this
        binding.rvMovies.adapter = adapter
    }

    override fun onClick(movie: Movie) {
       findNavController().navigate(MoviesFragmentDirections.actionMoviesFragmentToDetailFragment(movie))
    }
}