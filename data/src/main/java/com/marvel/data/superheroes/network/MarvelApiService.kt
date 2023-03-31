/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// This should be better hidden!
private const val BASE_URL = "https://gateway.marvel.com/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object MarvelApi {
    val retrofitService: MarvelApiService by lazy {
        retrofit.create(MarvelApiService::class.java)
    }
}

interface MarvelApiService {
    // This should be better hidden as well, not secure at all to have it here!
    @GET("v1/public/characters?ts=1&apikey=3a305338cb0c85295902fc57ca6b359f&hash=0eaaf1dba27fd7a758c806b5f569850e")
    suspend fun getSuperheroes(): SuperheroResponse
}
