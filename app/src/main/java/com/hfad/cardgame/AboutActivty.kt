package com.hfad.cardgame

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AboutActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_activty)

        val buttonHome = findViewById<ImageButton>(R.id.btStat)



        buttonHome.setOnClickListener {
            finish()
        }

    }


}