package com.example.lesson01_month07.domain.usecase

import com.example.lesson01_month07.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun getaAllNotes() = noteRepository.getAllNotes()
}