package com.example.rickyapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickyapp.data.entities.ResultCharacter


@Dao
interface CharacterDAO {
    // API response is stored
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(result: List<ResultCharacter>)

    // Display in recyclerview
    @Query("SELECT * FROM RickMartin_Characters")
    fun getAllCharacters() : LiveData<List<ResultCharacter>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(character: ResultCharacter)

    @Query("SELECT * FROM RickMartin_Characters WHERE id= :id")
    fun getCharacter(id: Int) : LiveData<ResultCharacter>
}