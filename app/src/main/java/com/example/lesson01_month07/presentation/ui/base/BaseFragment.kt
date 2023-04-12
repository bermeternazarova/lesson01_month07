package com.example.lesson01_month07.presentation.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lesson01_month07.presentation.utils.UIState
import com.example.lesson01_month07.presentation.utils.showToast
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment(
    @LayoutRes layoutId: Int )
    :Fragment(layoutId){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpRequest()
        setArguments()
        setUPSubscriber()
        setUpListener()
    }

    open fun setUpListener(){}

    open fun setUPSubscriber(){}

    open fun setUpRequest(){}

    open fun initialize(){}

    open fun setArguments(){}

    protected fun <T>StateFlow<UIState<T>>.collectUiState(
      state:((UIState<T>) -> Unit)?=null ,
      onSuccess:(data:T) ->Unit
  ){
      viewLifecycleOwner.lifecycleScope.launch {
          repeatOnLifecycle(Lifecycle.State.STARTED) {
              this@collectUiState.collect {
                  state?.invoke(it)
                  when (it) {
                      is UIState.Empty -> {}
                      is UIState.Error -> {
                          showToast(it.message)
                      }
                      is UIState.Loading -> {}
                      is UIState.Success -> {
                          onSuccess(it.data)
                      }
                      }
                  }
              }
          }
      }
  }