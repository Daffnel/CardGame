package com.hfad.cardgame

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CardsViewModel : ViewModel() {

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

    fun checkGuesses(hiLoButton: String): Boolean {  // HI = for high button LO= for low button Return Boolean for right or wrong answer

        val firstCardInStack = deck1.convertNumber(cards.indexOf(cardCount - 1)) //-1 because showCard() is one card ahead
        val secondCardInStack = deck1.convertNumber(cards.indexOf(cardCount))

        var answer = false

        if (hiLoButton == "HI") {
            if (firstCardInStack <= secondCardInStack) {   //equals makes a right answer
                Log.d("CardsViewModel", "HI Rätt")
                answer = true
            } else {
                Log.d("CardsViewModel", "HI fel")
                answer = false
            }
        }
        if (hiLoButton == "LO") {
            if (firstCardInStack >= secondCardInStack) {
                Log.d("CardsViewModel", "LO Rätt")
                answer = true
            } else {
                Log.d("CardsViewModel", "LO fel")
                answer = false
            }
        }
        showCard()
        return answer
    }
        fun buttonHigh() {

            checkGuesses("HI")

        }

        fun buttonLow() {

            checkGuesses("LO")
        }


    }