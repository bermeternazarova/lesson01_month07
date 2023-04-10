package com.example.lesson01_month07.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.Provides

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun doNoteDataBase(): NoteDao
}