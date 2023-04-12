package com.example.lesson01_month07.presentation.ui.fragments

import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson01_month07.R
import com.example.lesson01_month07.databinding.FragmentNoteBinding
import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.presentation.ui.base.BaseFragment
import com.example.lesson01_month07.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : BaseFragment(R.layout.fragment_note) {

    private val binding by viewBinding(FragmentNoteBinding::bind)
    private val viewModel: NotesViewModel by viewModels()
    private val adapterNotes by lazy {
        AdapterNotes(this::onClick, this::onLOngClick)
    }

    private fun onClick(note: NOte) {
        findNavController().navigate(R.id.editNoteFragment2, bundleOf(UPDATE to note))
    }

    private fun onLOngClick(note: NOte) {
        showAlert(
            getString(R.string.delete),
            getString(R.string.no),
            getString(R.string.yes)
        ) { viewModel.deleteNote(note) }
    }


    override fun setUpListener() {
        super.setUpListener()
        binding.goFab.setOnClickListener {
            findNavController().navigate(R.id.editNoteFragment2)
        }
    }

    override fun setUPSubscriber() {
        super.setUPSubscriber()
        viewModel.getAllNOtesState.collectUiState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                viewModel.loading.postValue(false)
                binding.rv.adapter = adapterNotes
                adapterNotes.submitList(it.reversed())
            }
        )

        viewModel.deleteNoteState.collectUiState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                viewModel.loading.postValue(false)
                viewModel.getAllNOtes()
            }
        )
    }

    override fun setUpRequest() {
        super.setUpRequest()
        viewModel.getAllNOtes()
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }

    companion object {
        const val UPDATE = "ksdsfdjflskpo"
    }
    private fun showAlert(
        title: String, negativeMessage: String, positiveMessage: String, function: () -> Unit
    ) {
        val option = arrayOf(negativeMessage, positiveMessage)
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle(title).setItems(
            option
        ) { dialogInterface, i ->
            if (i == 0) {
                dialogInterface.dismiss()
            } else if (i == 1) {
                function()
            }
        }.show()
    }
}
