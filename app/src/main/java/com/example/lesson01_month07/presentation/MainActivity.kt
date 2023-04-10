package com.example.lesson01_month07.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson01_month07.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}