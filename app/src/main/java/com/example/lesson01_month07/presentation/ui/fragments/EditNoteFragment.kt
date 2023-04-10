package com.example.lesson01_month07.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson01_month07.R
import com.example.lesson01_month07.databinding.FragmentEditNoteBinding
import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.usecase.CreateNoteUseCase
import com.example.lesson01_month07.presentation.utils.UIState
import com.example.lesson01_month07.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class EditNoteFragment : Fragment(R.layout.fragment_edit_note) {

    private val binding by viewBinding(FragmentEditNoteBinding::bind)

    @Inject
    lateinit var createNoteUseCase: CreateNoteUseCase
    private val viewModel: EditNoteViewMOdel by viewModels()
    private lateinit var note: NOte
    private var noteIsNull = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupRequest()
        setArguments()
        setupSubscriber()
    }

    private fun setupRequest() {
        viewModel.loading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible=it
        }
    }

    private fun setupSubscriber() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.createNoteState.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            viewModel.loading.postValue(true)
                            showToast(it.message)
                        }
                        is UIState.Loading -> {
                            viewModel.loading.postValue(true)
                        }
                        is UIState.Success -> {
                            viewModel.loading.postValue(false)
                            findNavController().navigateUp()
                        }
                    }
                }
            }
        }
    }

    private fun setArguments() {
        binding.sendBtn.setOnClickListener {
            if (arguments != null) {
                updateNote(note)
            } else {
                saveNote()
            }
            findNavController().navigateUp()
        }
    }

    private fun saveNote() {
        if (binding.etTitle.text.isNotEmpty() && binding.etDesc.text.isNotEmpty()) {
            if (noteIsNull) {
                viewModel.addNote(
                    NOte(
                        title = binding.etTitle.text.toString(),
                        desc = binding.etDesc.text.toString()
                    )
                )
            }
        } else {
            showToast(getString(R.string.full))
        }
    }

    private fun updateNote(note: NOte) {
        note.title = binding.etTitle.text.toString()
        note.desc = binding.etDesc.text.toString()
        viewModel.editNote(note)
    }

    private fun initialize() {
        if (arguments != null) {
            note = arguments?.getSerializable(UPDATE) as NOte
            binding.etTitle.setText(note.title)
            binding.etDesc.setText(note.desc)
            binding.sendBtn.text = getString(R.string.edit)
            noteIsNull = false
        }
    }

    companion object {
        const val UPDATE = "ksdsfdjflskpo"
    }
}
