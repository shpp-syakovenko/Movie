package com.serglife.movie.presentation.ui.detail.adapter.holder.trailer

import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.domain.type.AdapterContentElement

class TrailerDataHolder( val trailer: Trailer): TypeDataHolder {
    override fun areItemTheSame(other: AdapterContentElement): Boolean {
        if(other !is TrailerDataHolder) return false
        return trailer.areItemTheSame(other.trailer)
    }

    override fun areContentTheSame(other: AdapterContentElement): Boolean {
        if(other !is TrailerDataHolder) return false
        return trailer.areContentTheSame(other.trailer)
    }
}