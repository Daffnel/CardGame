package com.hfad.cardgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardsViewModel: ViewModel() {

    private lateinit var deck1: Cards
    var cardCountNr: Int = 0 //  keep track which card is in play

init{
    var deck1: Cards = Cards()  //create a new shuffled deck
    deck1.randomizeCards()
}


    var currentImage = MutableLiveData<Int>()
   val cardImages = deck1.deckImgaesRef




/*fun showNextCard(){

    currentImage.value = cardImages[cardCountNr]?.toInt()

}*/



}