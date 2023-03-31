package com.example.lesson01_month07.domain.usecase

import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.repository.NoteRepository

class EditNoteUseCase(private val noteRepository: NoteRepository) {
    fun editNOte(note: NOte)=noteRepository.editNote(note)
}