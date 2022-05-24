package com.example.android.guesstheword.screens.title

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 24.05.2022               │
//└──────────────────────────┘

class TitleViewModel : ViewModel() {
   //UI'daki veri değişince değişseek LiveData
   val currentText = MutableLiveData<String>()
   val playButtonVisibility = Transformations.map(currentText) {
      PlayButtonViewState(it.length>=5)
   }
}