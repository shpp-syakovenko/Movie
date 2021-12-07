package com.serglife.movie.domain.usecase

import com.serglife.movie.data.common.Either
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.domain.repository.RepoTrailers

class GetTrailersByIdUseCase(private val repo: RepoTrailers) {
    suspend operator fun invoke(id:Int): Either<List<Trailer>>{
        return repo.getTrailersById(id)
    }
}