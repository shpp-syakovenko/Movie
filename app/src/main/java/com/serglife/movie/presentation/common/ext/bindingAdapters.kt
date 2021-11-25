package com.serglife.movie.presentation.common.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso



// Load poster from network and insert in to ImageView with helping lib a picasso

@BindingAdapter("posterMovie")
fun ImageView.loadPoster(url: String?) {
    if (url.isNullOrBlank()) {
        setImageDrawable(null)
    } else {
        Picasso
            .get()
            .load(url)
            .resize(200, 300)
            .centerCrop()
            .into(this)
    }
}
