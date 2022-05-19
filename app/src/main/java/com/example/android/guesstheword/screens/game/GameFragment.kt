/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {
    private lateinit var binding: GameFragmentBinding
    private lateinit var gameViewModel: GameViewModel   //Olusturulan VM extend edilir.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )
        //ViewModel oluşturma
        //gameViewModel= ViewModelProvider(requireActivity())[GameViewModel::class.java]
        gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]
        //VM create edildikten sonra çağrılır.
        updateWordText()
        updateScoreText()

        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }

        return binding.root
    }
    /** Methods for buttons presses **/
    private fun onSkip() {
        //Değişkenler VM içinden çağrılır.
        gameViewModel.onSkip()
        updateWordText()
        updateScoreText()

    }
    private fun onCorrect() {
        gameViewModel.onCorrect()
        updateWordText()
        updateScoreText()
    }
    /** Methods for updating the UI **/
    ///View'e ait özellikler var,bundan dolayı VM da bulunmaz.
    private fun updateWordText() {
        binding.wordText.text = gameViewModel.word
    }
    private fun updateScoreText() {
        binding.scoreText.text = gameViewModel.score.toString()
    }
}
