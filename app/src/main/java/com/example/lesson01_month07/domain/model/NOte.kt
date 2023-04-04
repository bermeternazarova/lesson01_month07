package com.example.lesson01_month07.domain.model

class NOte(
    val id: Int = DEFAULT_ID,
    val title: String,
    val desc: Int
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}
