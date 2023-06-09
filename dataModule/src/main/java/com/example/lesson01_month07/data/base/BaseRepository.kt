package com.example.lesson01_month07.data.base

import com.example.lesson01_month07.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (ioException: IOException) {
            emit(
                Resource.Error(
                    ioException
                        .localizedMessage ?: "Unknown error "
                )
            )
        }
    }.flowOn(Dispatchers.IO)

}