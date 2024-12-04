package com.hfad.cardgame

data class Game (var player: String){

    var points: Int = 0
    var draw: Int = 0

    var NoGuesses = 0
    var correctGuesses = 0
    var wrongGuesses = 0

}