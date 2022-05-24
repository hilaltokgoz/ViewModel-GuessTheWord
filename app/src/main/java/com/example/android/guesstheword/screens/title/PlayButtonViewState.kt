package com.example.android.guesstheword.screens.title

import android.view.View

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 24.05.2022               │
//└──────────────────────────┘
//UI View State Ornegi.
//PlayButtonViewState ın state'ini isPlayButtonVisible tutar.
data class PlayButtonViewState(private val isPlayButtonVisible: Boolean) {
    fun getPlayButtonVisibility() = if (isPlayButtonVisible) View.VISIBLE else View.INVISIBLE

 companion object{
     fun initial()=PlayButtonViewState(false)
 }
}
