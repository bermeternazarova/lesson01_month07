package com.example.lesson01_month07.domain.usecase

import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.repository.NoteRepository

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {
    fun deleteNOte(nOte: NOte)=noteRepository.deleteNote(nOte)
}