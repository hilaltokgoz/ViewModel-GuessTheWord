package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 19.05.2022               │
//└──────────────────────────┘

class ScoreViewModel(private val currentScore:Int):ViewModel() {

    val score=currentScore
}