package com.hfad.cardgame

import android.util.Log
import kotlin.random.Random

class Cards {

    var  randomizedDeck = mutableSetOf<Int>()


//table to hold information on suite and value in the order 1 to 52 Spades, hearts, diamonds, clubs
    val deck = mapOf(1 to "ace of spades",2 to "two of spades",3 to "three of spades",4 to "Four of spades",
        5 to "five of spades",6 to "six of spades",7 to "seven of spades",8 to "eight of spades",
        9 to "nine of spades",10 to "ten of spades",11 to "jack of spades",12 to "queen of spades",
        13 to "king of spades",

        14 to "ace of hearts",15 to "two of hearts",16 to "three of hearts",
        17 to "Four of hearts",18 to "five of hearts",19 to "six of hearts",20 to "seven of hearts",
        21 to "eight of hearts",22 to "nine of hearts",23 to "ten of hearts",24 to "jack of hearts",
        25 to "queen of hearts",26 to "king of hearts",

        27 to "ace of diamonds",28 to "two of diamonds",
        29 to "three of diamonds",30 to "Four of diamonds", 31 to "five of diamonds",32 to "six of diamonds",
        33 to "seven of diamonds",34 to "eight of diamonds",35 to "nine of diamonds",36 to "ten of diamonds",
        37 to "jack of diamonds",38 to "queen of diamonds",39 to "king of diamonds",

        40 to "ace of clubs",
        41 to "two of clubs",42 to "three of clubs",43 to "Four of clubs",
        44 to "five of clubs",45 to "six of clubs",46 to "seven of clubs",47 to "eight of clubs",
        48 to "nine of clubs",49 to "ten of clubs",50 to "jack of clubs",51 to "queen of clubs",
        52 to "king of clubs")

//table to convert the "deck's" 1 to 52 to the respective suites value

    val convertTable: Map<Int,Int> = mapOf(1 to 1,2 to 2, 3 to 3,4 to 4, 5 to 5, 6 to 6, 7 to 7, 8 to 8,
    9 to 9, 10 to 10, 11 to 11, 12 to 12, 13 to 13, 14 to 1, 15 to 2, 16 to 3, 17 to 4, 18 to 5, 19 to 6,
    20 to 7, 21 to 8, 22 to 9, 23 to 10, 24 to 11, 25 to 12, 26 to 13, 27 to 1, 28 to 2, 29 to 3, 30 to 4,
    31 to 5, 32 to 6, 33 to 7, 34 to 8, 35 to 9, 36 to 10, 37 to 11, 38 to 12, 39 to 13,
    40 to 1, 41 to 2, 42 to 3, 43 to 4, 44 to 5, 45 to 6, 46 to 7, 47 to 8, 48 to 9, 49 to 10,
    50 to 11, 51 to 12, 52 to 13)

    
    val deckImageRef: Map<Int,Int> = mapOf(1 to R.drawable.ace_of_spades,2 to R.drawable.two_of_spades,3 to R.drawable.three_of_spades,4 to R.drawable.four_of_spades,
        5 to R.drawable.five_of_spades,6 to R.drawable.six_of_spades,7 to R.drawable.seven_of_spades,8 to R.drawable.eight_of_spades,
        9 to R.drawable.nine_of_spades,10 to R.drawable.ten_of_spades,11 to R.drawable.jack_of_spades2,12 to R.drawable.queen_of_spades2,
        13 to R.drawable.king_of_spades2,14 to R.drawable.ace_of_hearts,15 to R.drawable.two_of_hearts, 16 to R.drawable.three_of_hearts,
        17 to R.drawable.four_of_hearts,18 to R.drawable.five_of_hearts,19 to R.drawable.six_of_hearts,20 to R.drawable.seven_of_hearts,
        21 to R.drawable.eight_of_hearts,22 to R.drawable.nine_of_hearts,23 to R.drawable.ten_of_hearts,24 to R.drawable.jack_of_hearts2,
        25 to R.drawable.queen_of_hearts2,26 to R.drawable.king_of_hearts2,27 to R.drawable.ace_of_diamonds,28 to R.drawable.two_of_hearts,
        29 to R.drawable.three_of_diamonds,30 to R.drawable.four_of_diamonds, 31 to R.drawable.five_of_diamonds,32 to R.drawable.six_of_diamonds,
        33 to R.drawable.seven_of_diamonds,34 to R.drawable.eight_of_diamonds,35 to R.drawable.nine_of_diamonds,36 to R.drawable.ten_of_diamonds,
        37 to R.drawable.jack_of_diamonds2,38 to R.drawable.queen_of_diamonds2,39 to R.drawable.king_of_diamonds2,40 to R.drawable.ace_of_clubs,
        41 to R.drawable.two_of_clubs,42 to R.drawable.three_of_clubs,43 to R.drawable.four_of_clubs,
        44 to R.drawable.five_of_clubs,45 to R.drawable.six_of_clubs,46 to R.drawable.seven_of_clubs,47 to R.drawable.eight_of_clubs,
        48 to R.drawable.nine_of_clubs,49 to R.drawable.ten_of_clubs,50 to R.drawable.jack_of_clubs2,51 to R.drawable.queen_of_clubs2,
        52 to R.drawable.wrong_answer,99 to R.drawable.wrong_answer)


    /**
     * Converts number 1 to 52 to numbers 1 to 13
     */

    fun convertNumber(number: Int): Int{

       val convertedNumber: Int? = convertTable[number]

        return convertedNumber ?: 0
    }

    /**
     * Makes a random deck of 52 cards. The numbers value is equivalent in deck list
     */
    fun randomizeCards(number: Int) {

        randomizedDeck.clear() //clears the current deck

        while(randomizedDeck.size+1 < number){
            val randomCardNo = Random.nextInt(1, 53)
            if(!randomizedDeck.contains(randomCardNo)){                     //Card do not exist, add to deck
                randomizedDeck.add(randomCardNo)
            }
            else{
                // Do nothing card already exists
            }
        }

            //TODO Kopntrollera att vi har en blandad kortlek
            randomizedDeck.forEachIndexed { index, element ->
            Log.d("!cards.kt", "Element at index $index: $element")
        }

    }


}
