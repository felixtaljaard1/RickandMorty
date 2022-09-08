package com.example.rickyapp.data.remote

import com.example.rickyapp.data.entities.RickCharacters
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {
    // List of characters
    @GET("character")
    suspend fun getAllCharacters() : Response<RickCharacters>
}