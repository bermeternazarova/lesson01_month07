package com.example.lesson01_month07.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes")
class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val title :String,
    val desc:Int,
    )