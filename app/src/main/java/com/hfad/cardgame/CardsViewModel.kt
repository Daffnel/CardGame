package com.hfad.cardgame

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CardsViewModel : ViewModel() {

    val currentCard = MutableLiveData<Int>()
    val answerImage = MutableLiveData<Int>()
    val answerText = MutableLiveData<String>()

    val noCorrectGuesses = MutableLiveData<Int>()
    val noOfGuesses = MutableLiveData<Int>()
    val noIncorrectGuesses = MutableLiveData<Int>()


    private val deck1 = Cards()

    private val cardImages = deck1.deckImageRef
    private val cards = deck1.randomizedDeck


    private var cardCount = 0

    init {
        deck1.randomizeCards(52)    //Skapa en blandad kortlek
        showCard()
    }

    fun showCard() {
        currentCard.value = cardImages[cards.indexOf(cardCount)]
        cardCount++
   }



    /***
     * Change the icon depending on the answer
     */
    private fun showAnswerImage(answer: Boolean) {

        when (answer) {
            true -> {
                answerImage.value = R.drawable.right_answer
                answerText.value = "CORRECT ANSWER"
                }
            false ->{ answerImage.value = R.drawable.wrong_answer
                answerText.value = "WRONG ANSWER"}
        }
        }

        private fun checkGuesses(hiLoButton: String) {  // HI = for high button LO= for low button Return Boolean for right or wrong answer

            val firstCardInStack =
                deck1.convertNumber(cards.indexOf(cardCount - 1)) //-1 because showCard() is one card ahead
            val secondCardInStack = deck1.convertNumber(cards.indexOf(cardCount))



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

            if(cardCount == 52){

                newGame()

            }
        }
    private fun newGame() {
        //Spara datan från tidigare spel


    }
    private fun gameStatics() {

        noCorrectGuesses.value = MainActivity.Game2Singelton.game2.correctGuesses
        noOfGuesses.value = MainActivity.Game2Singelton.game2.NoGuesses
        noIncorrectGuesses.value = MainActivity.Game2Singelton.game2.wrongGuesses
    }

        fun buttonHigh() {
            checkGuesses("HI")

        }

        fun buttonLow() {

            checkGuesses("LO")
        }

    }
