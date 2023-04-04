package com.example.lesson01_month07.data.repository

import com.example.lesson01_month07.data.base.BaseRepository
import com.example.lesson01_month07.data.mapper.toEntity
import com.example.lesson01_month07.data.mapper.toNOte
import com.example.lesson01_month07.data.model.NoteDao
import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDAo: NoteDao
) : NoteRepository,
    BaseRepository() {

    override fun createNote(nOte: NOte) = doRequest {
        noteDAo.createNote(nOte.toEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDAo.getAllNotes().map {
            it.toNOte()
        }
    }


    override fun editNote(nOte: NOte) = doRequest {
        noteDAo.editNotes(nOte.toEntity())
    }

    override fun deleteNote(nOte: NOte) = doRequest {
        noteDAo.deleteNOte(nOte.toEntity())
    }
}