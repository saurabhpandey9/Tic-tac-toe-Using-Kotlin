package com.developerdesk9.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

    }



    fun onBtnClick(view: View){

        var clickedBtn = view.id;

//        Log.d("msg","saurab")



        var curBtnId: Int= when(clickedBtn){
            R.id.button1 -> 1
            R.id.button2 -> 2
            R.id.button3 -> 3
            R.id.button4 -> 4
            R.id.button5 -> 5
            R.id.button6 -> 6
            R.id.button7 -> 7
            R.id.button8 -> 8
            R.id.button9 -> 9
            else -> -1
        }

        positionUpdate(curBtnId,view)


    }

    var currentPlayer =1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun positionUpdate(curBtnId:Int,view: View){
        var BTN = view as Button

        var chance = findViewById<TextView>(R.id.tv_chance)
        if (currentPlayer==1){
            player1.add(curBtnId)
            currentPlayer = 2
            BTN.setBackgroundColor(getColor(R.color.player1_color))
            BTN.text = "X"

            chance.text ="Chance of Player: $currentPlayer"
            chance.setTextColor(getColor(R.color.player2_color))


        }
        else if (currentPlayer==2){
            player2.add(curBtnId)
            currentPlayer = 1
            BTN.setBackgroundColor(getColor(R.color.player2_color))
            BTN.text = "O"
            chance.text ="Chance of Player: $currentPlayer"
            chance.setTextColor(getColor(R.color.player1_color))
        }


        view.setOnClickListener(null)
        winner()

    }

    private fun winner(){

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }




        // column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }

        // column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }

        // column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }


        // diagonal 3
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }
        // diagonal 3
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            Toast.makeText(applicationContext,"PLayer 1 Won",Toast.LENGTH_SHORT).show()
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            Toast.makeText(applicationContext,"PLayer 2 Won",Toast.LENGTH_SHORT).show()
        }

    }




}