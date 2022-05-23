package com.example.android.guesstheword.screens.game

import androidx.lifecycle.LiveData
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
   private val _wordLiveData= MutableLiveData<String>()
   val wordLiveData:LiveData<String> get()=_wordLiveData //Backing Field

    private val _scoreLiveData=MutableLiveData<Int>()
    val scoreLiveData:LiveData<Int> get()=_scoreLiveData

    //Oyun bittikten sonra değiştirilecek event'lar
    private val _gameFinishEventLiveData= MutableLiveData<Boolean>()
    val gameFinishEventLiveta:LiveData<Boolean> get()=_gameFinishEventLiveData
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    //Inıtialize İşlemleri için
    init {
        _scoreLiveData.value=0
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
            _wordLiveData.value=wordList.removeAt(0) //Otomatik olarak güncellendi
        }else{ //is empty
         onFinishGame()
        }
    }

    fun onSkip() {
        _scoreLiveData.value= _scoreLiveData.value?.minus(1)
       // score--
        nextWord()
    }
    fun onCorrect() {
        _scoreLiveData.value= _scoreLiveData.value?.plus(1)
       //j score++
        nextWord()
    }

    fun onFinishGame() {
      _gameFinishEventLiveData.value=true //oyun bitti
    }

    fun disableGameFinishEvent() {
       _gameFinishEventLiveData.value=false //ileri-geri gitmelerde vs
    }
}


