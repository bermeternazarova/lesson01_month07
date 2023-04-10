package com.example.lesson01_month07.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.lesson01_month07.R
import com.example.lesson01_month07.databinding.FragmentNoteBinding
import com.example.lesson01_month07.presentation.utils.UIState
import com.example.lesson01_month07.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private val viewModel: NotesViewModel by viewModels()
    private val adapterNotes by lazy {
        AdapterNotes()
    }
    private lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupRequest()
        setupSubscriber()
        initListeners()
    }

    private fun initListeners() {
        binding.goFab.setOnClickListener{
            findNavController().navigate(R.id.editNoteFragment2)
        }

    }

    private fun setupRequest() {
        viewModel.getAllNOtes()
    }

    private fun setupSubscriber() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllNOtesState.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            showToast(it.message)
                        }
                        is UIState.Loading -> {
                            //show progress bar dz3
                        }
                        is UIState.Success -> {
                            //отправка списка в адаптер dz3
                            binding.rv.apply {
                                adapter=adapterNotes
                                adapterNotes.addNotes(it.data)
                            }
                        }
                        //design dz3 2экрана список и кнопка для открытия 2о экрана
                        //навграф добавить
                        //обработать запросы
                        // подключить viewbindingPropertydelegate
                    }
                }
            }
        }
    }

    private fun initialize() {

    }
    companion object {
        const val NOTE_PAIR = "skjjsdfj"
        const val DESC_PAIR = "sdssdfjkf"
    }

}