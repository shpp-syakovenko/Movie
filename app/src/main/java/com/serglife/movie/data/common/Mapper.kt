package com.serglife.movie.data.common

import com.serglife.movie.data.entity.dto.MovieDto
import com.serglife.movie.domain.entity.Movie

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
}