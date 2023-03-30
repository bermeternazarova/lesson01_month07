package com.example.lesson01_month07.domain.repository

import com.example.lesson01_month07.domain.model.NOte

interface NoteRepository {
    fun createNote(nOte: NOte)
    fun getAllNotes():List<NOte>
    fun editNote(nOte: NOte)
    fun deleteNote(nOte: NOte)

}