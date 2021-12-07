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
import androidx.navigation.fragment.navArgs
import com.serglife.movie.core.adapter.TypeAdapter
import com.serglife.movie.data.common.ConstantNetwork
import com.serglife.movie.databinding.FragmentDetailBinding
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.presentation.ui.detail.adapter.DetailItemsFactory
import com.serglife.movie.presentation.ui.detail.adapter.holder.trailer.TrailerEventsHolder
import com.serglife.movie.presentation.ui.detail.adapter.listener.ClickTrailerListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment(), ClickTrailerListener{

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

        vm.loadDetailMovie(args.movie)
        vm.detailItems.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

    }

    private fun initEvents() {
        adapter.setEventHolder(
            eventHolder = TrailerEventsHolder().apply {
                trailerClickListener = this@DetailFragment
            },
            type = DetailItemsFactory.TYPE_TRAILER
        )
    }

    private fun initFieldDetail() {
        binding.lifecycleOwner = viewLifecycleOwner
        val itemsFactory = DetailItemsFactory()
        adapter = TypeAdapter(itemsFactory)
        binding.rvDetailMovie.adapter = adapter
    }

    override fun clickTrailer(trailer: Trailer) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ConstantNetwork.BASE_TRAILER_URL + trailer.key))
        startActivity(intent)
    }
}