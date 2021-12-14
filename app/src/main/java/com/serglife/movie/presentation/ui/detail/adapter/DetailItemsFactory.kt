package com.serglife.movie.presentation.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.serglife.movie.R
import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.core.adapter.TypeItemsFactory
import com.serglife.movie.core.adapter.TypeViewHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.movie.MovieDataHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.movie.MovieEventsHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.movie.MovieViewHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.trailer.TrailerDataHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.trailer.TrailerEventsHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.trailer.TrailerViewHolder

class DetailItemsFactory : TypeItemsFactory() {
    override fun getDataHolderType(holder: TypeDataHolder) =
        when (holder) {
            is MovieDataHolder -> TYPE_MOVIE
            is TrailerDataHolder -> TYPE_TRAILER
            else -> throw RuntimeException("$holder is can't parse type for holder")
        }

    override fun bindHolders(viewHolder: TypeViewHolder, dataHolder: TypeDataHolder) {

        val type = getDataHolderType(dataHolder)
        val eventHolder = eventHolders[type]
        when (type) {
            TYPE_MOVIE -> {
                (viewHolder as MovieViewHolder).bind(
                    dataHolder as MovieDataHolder,
                    eventHolder as? MovieEventsHolder
                )
            }
            TYPE_TRAILER -> {
                (viewHolder as TrailerViewHolder)
                    .bind(
                        dataHolder as TrailerDataHolder,
                        eventHolder as? TrailerEventsHolder
                    )
            }
        }
    }

    override fun createViewHolder(
        context: Context?,
        parentView: ViewGroup,
        type: Int
    ): TypeViewHolder {

        when (type) {
            TYPE_MOVIE -> {
                return MovieViewHolder(
                    LayoutInflater.from(context).inflate(
                        R.layout.item_header_detail_movie,
                        parentView,
                        false
                    )
                )
            }
            TYPE_TRAILER -> {
                return TrailerViewHolder(
                    LayoutInflater.from(context).inflate(
                        R.layout.item_trailer_detail_movie,
                        parentView,
                        false
                    )
                )
            }
            else -> throw RuntimeException("")

        }

    }

    companion object {
        const val TYPE_MOVIE = 0
        const val TYPE_TRAILER = 1
    }
}