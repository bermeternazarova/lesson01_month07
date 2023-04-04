package com.example.lesson01_month07.data.model

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes ")
    suspend fun getAllNotes(): List<NoteEntity>

    @Update
    suspend fun editNotes(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNOte(noteEntity: NoteEntity)
}