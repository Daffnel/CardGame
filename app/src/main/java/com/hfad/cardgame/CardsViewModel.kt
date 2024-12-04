package com.hfad.cardgame

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CardsViewModel: ViewModel() {

     val currentCard = MutableLiveData<Int>()
    private val deck1 = Cards()
    val cardImages = deck1.deckImageRef
    val cards = deck1.randomizedDeck

    var cardCount = 0                       //kortleken startar på 0?

    init {
        deck1.randomizeCards()             //Skapa en balndad kortlek
    }

    fun showCard() {
        currentCard.value = cardImages[cards.indexOf(cardCount)]
        cardCount++

        //Log.d("CardsViewModel","Current card is ${deck1.convertNumber(cards.indexOf(cardCount))}")

    }

    fun checkGuesses(answer: String): Boolean{  // HI = for high button LO= for low button Return Boolean for right or wrong answer

       // val singleNumber = deck1.convertNumber(cards.indexOf(cardCount))[cardCount]

        val firstValueToCompare = deck1.convertNumber(cards.indexOf(cardCount))
        val secondValueToCompare = deck1.convertNumber(cards.indexOf(cardCount+1))

        //val firstValueToCompare = deck1.convertNumber(cards.indexOf(cardCount))
        //val secondValueToCompare = deck1.convertNumber(cards.indexOf(cardCount+1))

        Log.d("CardsViewModel","cartd count $cardCount Första värdet $firstValueToCompare och andra värdet $secondValueToCompare")
        Log.d("CardsViewModel","Svar $answer")
        Log.d("CardsViewModel","{$cards.indexOf(cardCount+1)}")
        Log.d("CardsViewModel","{$cards.indexOf(cardCount)}")
        when(answer){

            "HI" -> {if( secondValueToCompare > firstValueToCompare){
                Log.d("CardsViewModel","Rätt gissat")
                return true
            } else {
                Log.d("CardsViewModel","Fel gissat")
            }}

            "LO" -> {if( secondValueToCompare < firstValueToCompare){
                Log.d("CardsViewModel","Rätt gissat")
                return true
            } else {
                Log.d("CardsViewModel","Fel gissat")

            }}

            else -> {
                Log.d("CardsViewModel","Här ska vu inte hamna")
            }
        }

        return false
    }

    fun buttonHigh(){
//Log.d("CardsViewModel","HI button tryckt")
checkGuesses("HI")

    }
fun buttonLow(){
//Log.d("CardsViewModel","LO button tryckt")
    checkGuesses("LO")
}


}