package com.example.thereapps.data.api

import com.example.thereapps.data.model.CatFactModel
import retrofit2.http.GET


interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}