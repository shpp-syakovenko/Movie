package com.serglife.movie.domain.entity

import android.os.Parcelable
import com.serglife.movie.domain.type.AdapterContentElement
import kotlinx.parcelize.Parcelize


@Parcelize
class Movie(
    val id: Int = 1,
    val poster_path: String? = "",
    val title: String = "",
    val overview: String = "",
    val vote_average: Double = 1.0,
    val release_date: String = "",
    var isFavorites: Boolean = false
) : Parcelable, AdapterContentElement {
    override fun areItemTheSame(other: AdapterContentElement): Boolean {
        if (other !is Movie) return false
        return id == other.id
    }

    override fun areContentTheSame(other: AdapterContentElement): Boolean {
        if (other !is Movie) return false
        return id == other.id
                && poster_path == other.poster_path
                && title == other.title
                && overview == other.overview
                && vote_average == other.vote_average
                && release_date == other.release_date
                && isFavorites == other.isFavorites
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (id != other.id) return false
        if (poster_path != other.poster_path) return false
        if (title != other.title) return false
        if (overview != other.overview) return false
        if (vote_average != other.vote_average) return false
        if (release_date != other.release_date) return false
        if (isFavorites != other.isFavorites) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (poster_path?.hashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + overview.hashCode()
        result = 31 * result + vote_average.hashCode()
        result = 31 * result + release_date.hashCode()
        result = 31 * result + isFavorites.hashCode()
        return result
    }

    fun clone() = Movie(
        id = id,
        poster_path = poster_path,
        title = title,
        overview = overview,
        vote_average = vote_average,
        release_date = release_date,
        isFavorites = isFavorites
    )
}