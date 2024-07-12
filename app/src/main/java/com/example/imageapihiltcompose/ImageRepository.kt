package com.example.imageapihiltcompose

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepository @Inject constructor(private val apiService: ApiService) {

    fun getImages() : Flow<List<ImageItem>> = flow {
        emit(apiService.getImages())
    }
}