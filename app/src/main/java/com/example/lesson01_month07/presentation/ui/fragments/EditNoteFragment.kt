package com.example.lesson01_month07.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson01_month07.databinding.FragmentEditNoteBinding
import com.example.lesson01_month07.domain.model.NOte
import com.example.lesson01_month07.domain.model.NOte.Companion.DEFAULT_ID
import com.example.lesson01_month07.domain.usecase.CreateNoteUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditNoteFragment : Fragment() {

    private lateinit var binding: FragmentEditNoteBinding
    @Inject
    lateinit var createNoteUseCase: CreateNoteUseCase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNoteBinding.inflate(inflater, container, false)
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
        binding.sendBtn.setOnClickListener {
                createNoteUseCase.createNOte(
                    NOte(
                        id = DEFAULT_ID, title = binding.etTitle.text.toString(),
                        desc = binding.etDesc.text.toString().toInt()
                    )
                )
        }
    }

    private fun setupSubscriber() {

    }

    private fun setupRequest() {

    }

    private fun initialize() {

    }

    companion object {
        const val NOTE_PAIR = "skjjsdfj"
        const val DESC_PAIR = "sdssdfjkf"
    }

}