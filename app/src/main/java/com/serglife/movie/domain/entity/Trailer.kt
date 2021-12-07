package com.serglife.movie.domain.entity

import com.serglife.movie.domain.type.AdapterContentElement


class Trailer(
    val id: String,
    val name: String,
    val key: String
): AdapterContentElement{
    override fun areItemTheSame(other: AdapterContentElement): Boolean {
        if(other !is Trailer) return false
        return id == other.id
    }

    override fun areContentTheSame(other: AdapterContentElement): Boolean {
        if(other !is Trailer) return false
        return id == other.id && name == other.name && key == other.key
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Trailer

        if (id != other.id) return false
        if (name != other.name) return false
        if (key != other.key) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + key.hashCode()
        return result
    }
}