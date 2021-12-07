package com.serglife.movie.domain.repository

import com.serglife.movie.data.common.Either
import com.serglife.movie.domain.entity.Trailer

interface RepoTrailers {
    suspend fun getTrailersById(id:Int):Either<List<Trailer>>
}