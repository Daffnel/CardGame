package com.hfad.cardgame

import android.util.Log
import kotlin.random.Random

class Cards {

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



    /*randomize a number an number between 0 and 52 check if that card is playable */

    fun randomizeCards() {

        val randCard = Random.nextInt(1, 53)

        if(deck.containsKey(randCard))
            Log.d("!!!", deck[randCard].toString())

    }


}
