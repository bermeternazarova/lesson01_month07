package com.example.lesson01_month07.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson01_month07.R
import com.example.lesson01_month07.databinding.FragmentNoteBinding
import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.presentation.utils.UIState
import com.example.lesson01_month07.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteFragment : Fragment(R.layout.fragment_note) {

    private val binding by viewBinding(FragmentNoteBinding::bind)
    private val viewModel: NotesViewModel by viewModels()
    private val adapterNotes by lazy {
        AdapterNotes(this::onClick,this::onLOngClick)
    }

    private fun onClick(note:NOte) {
        findNavController().navigate(R.id.editNoteFragment2, bundleOf(UPDATE to note ))
    }
    private fun onLOngClick(note: NOte){
        val option = arrayOf(getString(R.string.no),getString(R.string.yes))
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle(getString(R.string.delete)).setItems(option
        ) { dialogInterface, i ->
            if (i == 0) {
                dialogInterface.dismiss()
            } else if (i == 1) {
                viewModel.deleteNote(note)
            }
        }.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRequest()
        setupSubscriber()
        initListeners()
    }

    private fun initListeners() {
        binding.goFab.setOnClickListener {
            findNavController().navigate(R.id.editNoteFragment2)
        }
    }
    private fun setupRequest() {
        viewModel.getAllNOtes()
        viewModel.loading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible=it
        }
    }

    private fun setupSubscriber() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllNOtesState.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            showToast(it.message)
                            viewModel.loading.postValue(true)
                        }
                        is UIState.Loading -> {
                            //show progress bar dz3
                            viewModel.loading.postValue(true)
                        }
                        is UIState.Success -> {
                            viewModel.loading.postValue(false)
                            //отправка списка в адаптер dz3
                            binding.rv.apply {
                                adapter = adapterNotes
                                adapterNotes.addNotes(it.data)
                            }
                        }
                    }
                }
            }
        }
    }
    companion object {
        const val UPDATE = "ksdsfdjflskpo"
    }
}