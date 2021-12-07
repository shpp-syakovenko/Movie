package com.serglife.movie.data.common

import com.serglife.movie.data.entity.dto.MovieDto
import com.serglife.movie.data.entity.dto.TrailerDto
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.entity.Trailer

class Mapper {
    private fun movieDtoToMovie(movieDto: MovieDto): Movie{
        return Movie(
            id = movieDto.id,
            poster_path = ConstantNetwork.BASE_IMAGE_URL + movieDto.poster_path,
            title = movieDto.title,
            vote_average = movieDto.vote_average,
            overview = movieDto.overview,
            release_date = movieDto.release_date
        )
    }

    fun listMovieDtoToListMovie(listMovieDto: List<MovieDto>): List<Movie>{
        return listMovieDto.map { movieDto ->
            movieDtoToMovie(movieDto)
        }
    }

    private fun trailerDtoToTrailer(trailerDto: TrailerDto): Trailer {
        return Trailer(
            id = trailerDto.id,
            name = trailerDto.name,
            key = trailerDto.key
        )
    }

    fun listTrailersDtoToListTrailers(listTrailersDto: List<TrailerDto>): List<Trailer>{
        return listTrailersDto.map { trailerDto ->
            trailerDtoToTrailer(trailerDto)
        }
    }
}