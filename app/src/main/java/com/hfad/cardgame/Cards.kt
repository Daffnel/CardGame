package com.hfad.cardgame

import android.util.Log
import kotlin.random.Random

class Cards {

    var  randomizedDeck = mutableSetOf<Int>()
    var  usedCards = mutableSetOf<Int>()

    val deck = mapOf(1 to "ace_of_spades",2 to "two_of_spades",3 to "three_of_spades",4 to "Four_of_spades",
        5 to "five_of_spades",6 to "six_of_spades",7 to "seven_of_spades",8 to "eight_of_spades",
        9 to "nine_of_spades",10 to "ten_of_spades",11 to "jack_of_spades",12 to "queen_of_spades",
        13 to "king_of_spades",14 to "ace_of_hearts",15 to "two_of_hearts",16 to "three_of_hearts",
        17 to "Four_of_hearts",18 to "five_of_hearts",19 to "six_of_hearts",20 to "seven_of_hearts",
        21 to "eight_of_hearts",22 to "nine_of_hearts",23 to "ten_of_hearts",24 to "jack_of_hearts",
        25 to "queen_of_hearts",26 to "king_of_hearts",27 to "ace_of_diamonds",28 to "two_of_diamonds",
        29 to "three_of_diamonds",30 to "Four_of_diamonds", 31 to "five_of_diamonds",32 to "six_of_diamonds",
        33 to "seven_of_diamonds",34 to "eight_of_diamonds",35 to "nine_of_diamonds",36 to "ten_of_diamonds",
        37 to "jack_of_diamonds",38 to "queen_of_diamonds",39 to "king_of_diamonds",40 to "ace_of_clubs",
        41 to "two_of_clubs",42 to "three_of_clubs",43 to "Four_of_clubs",
        44 to "five_of_clubs",45 to "six_of_clubs",46 to "seven_of_clubs",47 to "eight_of_clubs",
        48 to "nine_of_clubs",49 to "ten_of_clubs",50 to "jack_of_clubs",51 to "queen_of_clubs",
        52 to "king_of_clubs")


    //Todo  Skapa en "blandad kortlek i en lista
    //Todo  sedan en lista över kort som är förbrukade


    /**
     * Makes a random deck of 52 cards. The numbers value is equalent in deck list
     */
    fun randomizeCards() {

        randomizedDeck.clear() //clears the current deck

        while(randomizedDeck.size < 52){
            val randomCardNo = Random.nextInt(1, 53)
            if(!randomizedDeck.contains(randomCardNo)){                     //Card do not exist, add to deck
                randomizedDeck.add(randomCardNo)
            }
            else{
                // Do nothing card already exists
            }
        }

            //TODO remove check that we a deck of cards
            randomizedDeck.forEachIndexed { index, element ->
            Log.d("!cards.kt", "Element at index $index: $element")
        }

    }

    /**
     *  Get the correct name for the card by its number
     */
    fun  getCardName(number: Int): String{

            val card: String? = deck[number]

            return card.toString()
        }




}
