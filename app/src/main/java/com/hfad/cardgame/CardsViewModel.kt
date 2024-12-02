package com.hfad.cardgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardsViewModel: ViewModel() {

var cardCountNr: Int = 0 //  keep track which card is in play

init{
    var deck1: Cards = Cards()  //create a new shuffled deck
    deck1.randomizeCards()
}

fun makeCardPictureReference(): Int{

   //var cardname = deck1.getCardName(cardCountNr)

    cardCountNr++

    return ("R.drawable."+ "cardname").toInt()

}

    //Set live data to observe button actions

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

    fun updateData(newData: String) {
       if(newData == "Higher"){
           _data.value = newData
       }
        _data.value = newData
    }



}