package com.serglife.movie.presentation.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.serglife.movie.R
import com.serglife.movie.core.adapter.TypeAdapter
import com.serglife.movie.data.common.ConstantNetwork
import com.serglife.movie.data.database.AUTH
import com.serglife.movie.data.database.DataBaseMovie
import com.serglife.movie.databinding.FragmentDetailBinding
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.presentation.ui.detail.adapter.DetailItemsFactory
import com.serglife.movie.presentation.ui.detail.adapter.holder.movie.MovieEventsHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.trailer.TrailerEventsHolder
import com.serglife.movie.presentation.ui.detail.adapter.listener.ClickMovieListener
import com.serglife.movie.presentation.ui.detail.adapter.listener.ClickTrailerListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment(), ClickTrailerListener, ClickMovieListener {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var adapter: TypeAdapter
    private val args by navArgs<DetailFragmentArgs>()
    private val vm: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDetailBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFieldDetail()
        initEvents()

        vm.detailItems.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })


        if (AUTH.currentUser != null) {
            vm.updateFavorites()
            vm.moviesFavorites.observe(viewLifecycleOwner, { listMovie ->
                val newMovie = args.movie.clone()
                newMovie.isFavorites = listMovie.any { it.id == args.movie.id }
                loadDetailMovie(newMovie)
            })
        } else {
            loadDetailMovie(args.movie)
        }
    }

    private fun initFieldDetail() {
        binding.lifecycleOwner = viewLifecycleOwner
        val itemsFactory = DetailItemsFactory()
        adapter = TypeAdapter(itemsFactory)
        binding.rvDetailMovie.adapter = adapter
    }


    private fun loadDetailMovie(movie: Movie) {
        vm.loadDetailMovie(movie)
    }

    private fun initEvents() {
        adapter.setEventHolder(
            eventHolder = TrailerEventsHolder().apply {
                trailerClickListener = this@DetailFragment
            },
            type = DetailItemsFactory.TYPE_TRAILER
        )
        adapter.setEventHolder(
            eventHolder = MovieEventsHolder().apply {
                movieClickListener = this@DetailFragment
            },
            type = DetailItemsFactory.TYPE_MOVIE
        )
    }

    override fun clickAddOrDeleteMovieFromFavorites(movie: Movie) {
        if (AUTH.currentUser != null) {
            if (movie.isFavorites) {
                vm.deleteFavorites(movie) {
                    Toast.makeText(
                        context,
                        "This movie delete from favorites!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                vm.addFavorites(movie) {
                    Toast.makeText(context, "This movie add to favorites!!!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        } else {
            findNavController().navigate(R.id.inLoginFragment)
        }
    }


    override fun clickTrailer(trailer: Trailer) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(ConstantNetwork.BASE_TRAILER_URL + trailer.key)
        )
        startActivity(intent)
    }
}