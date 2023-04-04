package com.example.lesson01_month07.di

import android.content.Context
import androidx.room.Room
import com.example.lesson01_month07.data.model.NoteDao
import com.example.lesson01_month07.data.model.NoteDataBase
import com.example.lesson01_month07.data.repository.NoteRepositoryImpl
import com.example.lesson01_month07.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteAppModule {

    @Singleton
    @Provides
    fun provideRoomNoteDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, NoteDataBase::class.java, "notes"
    )

    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) = noteDataBase.noteDataBase()

    @Provides
    fun provideNOteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)
}