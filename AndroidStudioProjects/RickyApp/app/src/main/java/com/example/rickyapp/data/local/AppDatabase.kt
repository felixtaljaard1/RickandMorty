package com.example.rickyapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickyapp.data.entities.ResultCharacter


@Database(entities = [ResultCharacter::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDAO(): CharacterDAO

    companion object{
        @Volatile private var INSTANCE: AppDatabase?= null

        fun getDatabase(context: Context) : AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also{ INSTANCE = it}
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "RMC")
                .fallbackToDestructiveMigration()
                .build()

    }
}