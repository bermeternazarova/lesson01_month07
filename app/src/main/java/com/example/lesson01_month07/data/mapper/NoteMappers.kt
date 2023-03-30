package com.example.lesson01_month07.data.mapper

import com.example.lesson01_month07.data.model.NoteEntity
import com.example.lesson01_month07.domain.model.NOte

fun NOte.toEntity()=NoteEntity(
    id,title,desc
)
fun NoteEntity.toNOte()=NOte(
    id,title,desc
)