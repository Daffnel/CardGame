package com.hfad.cardgame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        val buttonHome = findViewById<Button>(R.id.btHome)
        val buttonExit = findViewById<Button>(R.id.btExit)

        buttonHome.setOnClickListener {
            finish()
        }
        buttonExit.setOnClickListener {
            finishAffinity()
        }

    }
}