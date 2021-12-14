package com.serglife.movie.presentation.ui.detail.adapter.holder.movie

import com.serglife.movie.core.adapter.TypeEventsHolder
import com.serglife.movie.presentation.ui.detail.adapter.listener.ClickMovieListener

class MovieEventsHolder : TypeEventsHolder {
    var movieClickListener: ClickMovieListener? = null
}