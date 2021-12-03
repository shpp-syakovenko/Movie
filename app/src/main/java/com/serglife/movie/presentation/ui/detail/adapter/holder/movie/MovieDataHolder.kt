package com.serglife.movie.presentation.ui.detail.adapter.holder.movie

import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.type.AdapterContentElement

class MovieDataHolder(val movie: Movie): TypeDataHolder {
    override fun areItemTheSame(other: AdapterContentElement): Boolean {
        if(other !is MovieDataHolder) return false
        return movie.areItemTheSame(other.movie)
    }

    override fun areContentTheSame(other: AdapterContentElement): Boolean {
        if(other !is MovieDataHolder) return false
        return movie.areContentTheSame(other.movie)
    }

}