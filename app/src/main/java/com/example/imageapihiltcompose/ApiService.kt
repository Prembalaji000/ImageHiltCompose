package com.example.imageapihiltcompose

import retrofit2.http.GET

interface ApiService {
    @GET ("photos")
    suspend fun getImages() : List<ImageItem>
}