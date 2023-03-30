package com.example.lesson01_month07.data.repository

import com.example.lesson01_month07.data.mapper.toEntity
import com.example.lesson01_month07.data.mapper.toNOte
import com.example.lesson01_month07.data.model.NoteDao
import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val noteDAo: NoteDao
):NoteRepository {
    override fun createNote(note: NOte) {
        noteDAo.createNote(note.toEntity())
    }

    override fun getAllNotes(): List<NOte> {
        return noteDAo.getAllNotes().map {
            it.toNOte()
        }
    }

    override fun editNote(note: NOte) {
        noteDAo.editNotes(note.toEntity())
    }

    override fun deleteNote(note: NOte) {
        noteDAo.deleteNOte(note.toEntity())
    }
}