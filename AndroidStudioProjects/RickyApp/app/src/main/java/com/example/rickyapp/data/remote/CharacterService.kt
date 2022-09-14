package com.example.rickyapp.data.remote

import com.example.rickyapp.data.entities.ResultCharacter
import com.example.rickyapp.data.entities.RickCharacters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    // List of characters
    @GET("character")
    suspend fun getAllCharacters() : Response<RickCharacters>


    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<ResultCharacter>
}