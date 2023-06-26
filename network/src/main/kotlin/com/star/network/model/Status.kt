package com.star.network.model

val Int.isInformationRange: Boolean
    get() = this in (100 .. 199)

val Int.isSuccessRange: Boolean
    get() = this in (200 .. 299)

val Int.isRedirectionRange: Boolean
    get() = this in (300 .. 399)

val Int.isClientErrorRange: Boolean
    get() = this in (400 .. 499)

val Int.isServerErrorRange: Boolean
    get() = this in (500 .. 599)
