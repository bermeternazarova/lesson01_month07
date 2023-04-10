package com.example.lesson01_month07.presentation.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.usecase.CreateNoteUseCase
import com.example.lesson01_month07.domain.usecase.EditNoteUseCase
import com.example.lesson01_month07.domain.utils.Resource
import com.example.lesson01_month07.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewMOdel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
):ViewModel() {
    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    val loading = MutableLiveData<Boolean>()

    fun addNote(note: NOte) {
        viewModelScope.launch {
            createNoteUseCase.createNOte(note).collect{
                when(it){
                    is Resource.Error -> {
                        _createNoteState.value=UIState.Error(it.message!!)
                    }
                    is Resource.Loading -> {
                        _createNoteState.value=UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data!=null){
                            _createNoteState.value= UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun editNote(note: NOte){
        viewModelScope.launch {
            editNoteUseCase.editNOte(note).collect{
                when(it){
                    is Resource.Error -> {
                        _editNoteState.value=UIState.Error(it.message!!)
                    }
                    is Resource.Loading -> {
                        _editNoteState.value=UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data!=null){
                            _editNoteState.value= UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}