package com.hfad.cardgame

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


   object Game2Singelton {
       var game2 = Game("Bosse black ace")
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val newGameButton = findViewById<Button>(R.id.btNewGame)
        val loginButton = findViewById<Button>(R.id.btUserName)



        newGameButton.setOnClickListener {

             val intent = Intent(this, GameActivity::class.java)

                startActivity(intent)

        }


        loginButton.setOnClickListener {

            loginPopUp()

            Game2Singelton.game2.points++
            Log.d("!!!", "${Game2Singelton.game2.points}")
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }




    }


fun loginPopUp(){

   val userNameForm = Dialog(this)

    userNameForm.setContentView(R.layout.login_pop_up)
    userNameForm.setCancelable(false)

    val buttonOK = userNameForm.findViewById<Button>(R.id.btOk)
    val userName = userNameForm.findViewById<EditText>(R.id.etUserName)

    userNameForm.show()

    buttonOK.setOnClickListener {

        Game2Singelton.game2.player = userName.text.toString()
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()

        userNameForm.dismiss()
    }

}


}