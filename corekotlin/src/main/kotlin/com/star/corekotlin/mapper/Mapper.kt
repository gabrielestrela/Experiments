package com.star.corekotlin.mapper

interface Mapper <in I, out O> {
    fun mapFrom(from: I): O
}
