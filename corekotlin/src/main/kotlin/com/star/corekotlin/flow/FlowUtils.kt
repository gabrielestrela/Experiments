package com.star.corekotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

fun <T> Flow<T>.handleErrors(handler: (t: Throwable) -> Unit): Flow<T> =
    catch { t -> handler(t) }
