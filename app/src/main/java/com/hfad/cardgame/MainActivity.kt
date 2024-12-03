package com.hfad.cardgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val newGameButton = findViewById<Button>(R.id.btNewGame)



      /*  var deck1: Cards = Cards()

        deck1.randomizeCards()

        deck1.getCardName(2)

        deck1.getCardName(48)*/



        newGameButton.setOnClickListener {

             val intent = Intent(this, GameActivity::class.java)

                startActivity(intent)

        }





    }





}