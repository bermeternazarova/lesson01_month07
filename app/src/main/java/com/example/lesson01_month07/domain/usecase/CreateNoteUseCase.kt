package com.example.lesson01_month07.domain.usecase

import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.repository.NoteRepository

class CreateNoteUseCase(private val noteRepository: NoteRepository) {
    fun createNOte (nOte: NOte)=noteRepository.createNote(nOte)
    fun getaAllNotes()=noteRepository.getAllNotes()
    fun editNOte(note:NOte)=noteRepository.editNote(note)
    fun deleteNOte(nOte:NOte)=noteRepository.deleteNote(nOte)
}