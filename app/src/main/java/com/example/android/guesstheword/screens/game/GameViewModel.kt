package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 18.05.2022               │
//└──────────────────────────┘

class GameViewModel: ViewModel() {
    // The current word
    private var word = ""

    // The current score
    private var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    //Inıtialize İşlemleri için
    init {

    }


}