package com.serglife.movie.presentation.common.views

import androidx.recyclerview.widget.RecyclerView

class ScrollMoreListener(
    private val scrollDirection: Int,
    private val onLoadMore: () -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)

        when (newState) {
            RecyclerView.SCROLL_STATE_IDLE -> {
                val adapter = recyclerView.adapter ?: return
                if (!recyclerView.canScrollVertically(scrollDirection) && adapter.itemCount > 0) {
                    onLoadMore.invoke()
                }
            }
        }
    }

    companion object {
        const val SCROLL_DIRECTION_UP = -1
        const val SCROLL_DIRECTION_BOTTOM = 1
    }
}