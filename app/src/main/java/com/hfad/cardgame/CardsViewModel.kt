package com.hfad.cardgame

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CardsViewModel : ViewModel() {

    val currentCard = MutableLiveData<Int>()
    val answerImage = MutableLiveData<Int>()
    val answerText = MutableLiveData<String>()
    private val deck1 = Cards()
    val game = Game("Hasse korthaj")
    val cardImages = deck1.deckImageRef
    val cards = deck1.randomizedDeck





    var cardCount = 0                       //kortleken startar på 0?

    init {
        deck1.randomizeCards(52)             //Skapa en balndad kortlek
    }

    fun showCard() {
        currentCard.value = cardImages[cards.indexOf(cardCount)]
        cardCount++



    }

    /***
     * Change the icon depending on the answer
     */
    fun showAnswerImage(answer: Boolean) {

        when (answer) {
            true -> {
                answerImage.value = R.drawable.right_answer
                answerText.value = "CORRECT ANSWER"
                }
            false ->{ answerImage.value = R.drawable.wrong_answer
                answerText.value = "WRONG ANSWER"}
        }
        }

        fun checkGuesses(hiLoButton: String) {  // HI = for high button LO= for low button Return Boolean for right or wrong answer

            val firstCardInStack =
                deck1.convertNumber(cards.indexOf(cardCount - 1)) //-1 because showCard() is one card ahead
            val secondCardInStack = deck1.convertNumber(cards.indexOf(cardCount))

            var answer = false

            if (hiLoButton == "HI") {
                if (firstCardInStack <= secondCardInStack) {   //equals makes a right answer
                    game.correctGuesses++
                    showAnswerImage(true)
                } else {
                    game.wrongGuesses++
                    showAnswerImage(false)
                }
            }
            if (hiLoButton == "LO") {
                if (firstCardInStack >= secondCardInStack) {
                   game.correctGuesses++
                    showAnswerImage(true)
                } else {
                    game.wrongGuesses++
                    showAnswerImage(false)
                }
            }
            showCard()
            game.NoGuesses++
        }

        fun buttonHigh() {
            checkGuesses("HI")

        }

        fun buttonLow() {

            checkGuesses("LO")
        }

    }
