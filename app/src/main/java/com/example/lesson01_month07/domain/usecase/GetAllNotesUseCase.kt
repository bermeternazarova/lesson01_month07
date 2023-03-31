package com.example.lesson01_month07.domain.usecase

import com.example.lesson01_month07.domain.repository.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {
    fun getaAllNotes()=noteRepository.getAllNotes()
}