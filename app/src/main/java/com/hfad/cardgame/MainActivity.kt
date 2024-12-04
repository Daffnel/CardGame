package com.hfad.cardgame

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var userNameTextView: TextView

    object Game2Singelton {
       var game2 = Game("")
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val newGameButton = findViewById<Button>(R.id.btNewGame)
        val loginButton = findViewById<Button>(R.id.btUserName)
        userNameTextView = findViewById<TextView>(R.id.tvUserName)




        newGameButton.setOnClickListener {

             val intent = Intent(this, GameActivity::class.java)

                startActivity(intent)

        }


        loginButton.setOnClickListener {

            loginPopUp()


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

        updateName(userName.text.toString())

        userNameForm.dismiss()

    }

    //name.text = "hello"
}

    fun updateName(userName: String){
        this.userNameTextView.text =  "hello my friend " + userName
     }

}