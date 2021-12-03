package com.serglife.movie.presentation.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.serglife.movie.R
import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.core.adapter.TypeItemsFactory
import com.serglife.movie.core.adapter.TypeViewHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.movie.MovieDataHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.movie.MovieViewHolder

class DetailItemsFactory : TypeItemsFactory() {
    override fun getDataHolderType(holder: TypeDataHolder) =
        when(holder){
            is MovieDataHolder -> TYPE_MOVIE
            else -> throw RuntimeException("$holder is can't parse type for holder")
        }

    override fun bindHolders(viewHolder: TypeViewHolder, dataHolder: TypeDataHolder) {
        val type = getDataHolderType(dataHolder)

        when(type){
            TYPE_MOVIE -> {
                (viewHolder as MovieViewHolder).bind(dataHolder as MovieDataHolder)
            }
        }
    }

    override fun createViewHolder(
        context: Context?,
        parentView: ViewGroup,
        type: Int
    ): TypeViewHolder {

        when(type){
            TYPE_MOVIE -> {
                return MovieViewHolder(LayoutInflater.from(context).inflate(
                    R.layout.item_header_detail_movie,
                    parentView,
                    false))
            }
            else -> throw RuntimeException("")

        }

    }
    companion object{
        const val TYPE_MOVIE = 0
        const val TYPE_TRAILER = 1
    }
}