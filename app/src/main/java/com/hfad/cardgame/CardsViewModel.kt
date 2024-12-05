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

    val noCorrectGuesses = MutableLiveData<Int>()
    val noOfGuesses = MutableLiveData<Int>()
    val noIncorrectGuesses = MutableLiveData<Int>()


    private val deck1 = Cards()

    val cardImages = deck1.deckImageRef
    val cards = deck1.randomizedDeck


    var cardCount = 0                       //kortleken startar på 0?

    init {
        deck1.randomizeCards(52)    //Skapa en balndad kortlek
        showCard()
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
                    MainActivity.Game2Singelton.game2.correctGuesses++
                    showAnswerImage(true)
                } else {
                    MainActivity.Game2Singelton.game2.wrongGuesses++
                    showAnswerImage(false)
                }
            }
            if (hiLoButton == "LO") {
                if (firstCardInStack >= secondCardInStack) {
                   MainActivity.Game2Singelton.game2.correctGuesses++
                    showAnswerImage(true)
                } else {
                    MainActivity.Game2Singelton.game2.wrongGuesses++
                    showAnswerImage(false)
                }
            }
            showCard()
            MainActivity.Game2Singelton.game2.NoGuesses++
            gameStatics()
        }

    fun gameStatics() {

        noCorrectGuesses.value = MainActivity.Game2Singelton.game2.correctGuesses
        noOfGuesses.value = MainActivity.Game2Singelton.game2.NoGuesses
        noIncorrectGuesses.value = MainActivity.Game2Singelton.game2.wrongGuesses
    }

    fun buttonHigh() {
            checkGuesses("HI")
            Log.d("Cards", MainActivity.Game2Singelton.game2.NoGuesses.toString())
        }

        fun buttonLow() {

            checkGuesses("LO")
        }

    }
