package com.example.android.guesstheword.screens.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 18.05.2022               │
//└──────────────────────────┘

class GameViewModel : ViewModel() {
    // The current word
   // var word = ""
    // The current score
   // var score = 0
    //LiveDate Create
    val wordLiveData= MutableLiveData<String>()

    val scoreLiveData=MutableLiveData<Int>()
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    //Inıtialize İşlemleri için
    init {
        scoreLiveData.value=0
        resetList()
        nextWord()
    }
    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            //Select and remove a word from the list
           // word = wordList.removeAt(0) //UI ile ilgili
            wordLiveData.value=wordList.removeAt(0) //Otomatik olarak güncellendi
        }
    }
    fun onSkip() {
        scoreLiveData.value= scoreLiveData.value?.minus(1)
       // score--
        nextWord()
    }
    fun onCorrect() {
        scoreLiveData.value= scoreLiveData.value?.plus(1)
       //j score++
        nextWord()
    }
}


