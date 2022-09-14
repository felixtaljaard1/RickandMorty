package com.example.rickyapp.data.repository

import com.example.rickyapp.data.local.CharacterDAO
import com.example.rickyapp.data.remote.CharacterRemoteDataSource
import com.example.rickyapp.utils.performGetOperation
import javax.inject.Inject


/**
 * centralized location: data source which will be given to UI
 * database strategy
 */

class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDataSource: CharacterDAO
){
    fun getCharacters() = performGetOperation(
        databaseQuery = {localDataSource.getAllCharacters()},
        networkCall = {remoteDataSource.getCharacters()},
        saveCallResult = {localDataSource.insertAll(it.results)}
    )

    fun getCharacterDetailsData(id: Int) = performGetOperation(
        databaseQuery = {localDataSource.getCharacter(id)},
        networkCall = {remoteDataSource.getCharacterById(id)},
        saveCallResult = {localDataSource.insertDetails(it)}
    )
}