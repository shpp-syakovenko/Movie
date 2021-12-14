package com.serglife.movie.presentation.ui.detail.adapter.holder.trailer

import com.serglife.movie.core.adapter.TypeEventsHolder
import com.serglife.movie.presentation.ui.detail.adapter.listener.ClickMovieListener
import com.serglife.movie.presentation.ui.detail.adapter.listener.ClickTrailerListener

class TrailerEventsHolder: TypeEventsHolder {
    var trailerClickListener: ClickTrailerListener? = null
}