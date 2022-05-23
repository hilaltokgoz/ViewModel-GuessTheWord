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
import androidx.lifecycle.observe
import androidx.navigation.fragment.NavHostFragment
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.main_activity.*

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
        gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]
        //UI da LiveData'yı observe etme:
        //updateWordText()'i otomatik olarak alabiliriz.
        gameViewModel.wordLiveData.observe(viewLifecycleOwner) {
            binding.wordText.text = it
        }
        //updateScoreText()'i otomatik olarak alabiliriz.
        gameViewModel.scoreLiveData.observe(viewLifecycleOwner) {
            binding.scoreText.text = it.toString()
        }
        //DataBinding Variable değeri verildi
        binding.gameViewModel=gameViewModel
        binding.lifecycleOwner=viewLifecycleOwner //VM ın içeride observe edilmesi için

        gameViewModel.gameFinishEventLiveta.observe(viewLifecycleOwner) { hasGameFinished ->
            if (hasGameFinished) { //oyun bittiyse
                gameViewModel.disableGameFinishEvent()
                val action = GameFragmentDirections.actionGameToScore()
                action.score =
                    gameViewModel.scoreLiveData.value ?: 0 //Hiçbir şey gitmezse değer 0 olsun.
                NavHostFragment.findNavController(this).navigate(action)
            }

        }
/*
        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame()}*/

        return binding.root
    }
  /*  private fun onEndGame() {
        gameViewModel.onFinishGame()

    }
    *//** Methods for buttons presses **//*
    private fun onSkip() {
        //Değişkenler VM içinden çağrılır.
        gameViewModel.onSkip()
    }
    private fun onCorrect() {
        gameViewModel.onCorrect()
    }*/
}
