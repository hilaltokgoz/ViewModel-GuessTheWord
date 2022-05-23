package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

//Yapılandırıcısına bir şey geçirdiğimiz VM ın bir factory e ihtiyacı var.
class SCoreViewModelFactory(private val score:Int) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(ScoreViewModel::class.java)){ //Herhangi bir class'tan assign edilir mi?
           return ScoreViewModel(score) as T  //T tipinde istediği için
        }else{
            throw IllegalStateException("Can not create instance of this ViewModel") //Bu VM dan başka herhangi bir sınıf vs create edilmeye çalıştığında hata versin.
        }

    }
}