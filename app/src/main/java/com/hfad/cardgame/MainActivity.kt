package com.hfad.cardgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val newGameButton = findViewById<Button>(R.id.btNewGame)


        val deck1: Cards = Cards()

        newGameButton.setOnClickListener {

             val intent = Intent(this, GameActivity::class.java)

                startActivity(intent)

        }





    }





}