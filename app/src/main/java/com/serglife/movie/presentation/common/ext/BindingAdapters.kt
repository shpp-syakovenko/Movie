package com.serglife.movie.presentation.common.ext

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.serglife.movie.R
import com.squareup.picasso.Picasso


// Load poster from network and insert in to ImageView with helping lib a picasso

@BindingAdapter("loadPoster")
fun AppCompatImageView.loadImageMovie(url: String?) {
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

@BindingAdapter("loadPosterDetail")
fun AppCompatImageView.loadImageMovieDetail(url: String?) {
    if (url.isNullOrBlank()) {
        setImageDrawable(null)
    } else {
        Picasso
            .get()
            .load(url)
            .into(this)
    }
}

@BindingAdapter("loadText")
fun TextView.loadText(isFavorites: Boolean){
    if(isFavorites){
        this.text = this.context.getString(R.string.delete_to_favorites)
    }else{
        this.text = this.context.getString(R.string.add_to_favorites)
    }
}
