package com.example.android.guesstheword.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    //Event LiveData
    private val _onPlayAgainLiveData=MutableLiveData<Boolean>()
    val onPlayAgainLiveData:LiveData<Boolean> get()=_onPlayAgainLiveData
    val score=currentScore
    fun onPlayAgain() {
      _onPlayAgainLiveData.value=true
    }
    fun finishPlayAgainEvent(){
        _onPlayAgainLiveData.value=false
    }
}