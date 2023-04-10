package com.example.lesson01_month07.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes")
class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int?=null,
    @ColumnInfo(name = "title") var title: String?=null,
    @ColumnInfo(name = "desc") var desc: String?=null,
)