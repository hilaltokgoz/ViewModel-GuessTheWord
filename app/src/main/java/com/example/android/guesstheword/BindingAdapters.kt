package com.example.android.guesstheword

import android.widget.Button
import androidx.databinding.BindingAdapter

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Hilal TOKGOZ  │
//│ ──────────────────────── │
//│ hilaltokgoz98@gmail.com  │
//│ ──────────────────────── │
//│ 24.05.2022               │
//└──────────────────────────┘
//DataBindingAdapter uygulamalarda Utilies içinde yer alır

@BindingAdapter("playButtonVisibility") //Tanımlanacak attribute
fun Button.setPlayButtonVisibility(playButtonVisibility:Int) { //Nereye yazılacak Button,view vs
    this.visibility=playButtonVisibility
}