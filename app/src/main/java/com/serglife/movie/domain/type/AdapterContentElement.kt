package com.serglife.movie.domain.type

interface AdapterContentElement {
    fun areItemTheSame(other: AdapterContentElement):Boolean
    fun areContentTheSame(other: AdapterContentElement): Boolean
}