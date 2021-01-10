package com.developerdesk9.tictactoe

import android.graphics.Color
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var player1Score = 0
    var player2Score= 0

    var currentPlayer =1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
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


        view.isEnabled = false
        winner()

    }

    private fun winner(){

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            alertDialog(1)
        }
        else if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            alertDialog(2)
        }

        // row 2
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            alertDialog(1)
        }
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            alertDialog(2)
        }

        // row 3
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            alertDialog(1)
        }
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            alertDialog(2)
        }




        // column 1
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            alertDialog(1)
        }
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            alertDialog(2)
        }

        // column 2
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            alertDialog(1)
        }
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            alertDialog(2)
        }

        // column 3
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            alertDialog(1)
        }
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            alertDialog(2)
        }


        // diagonal 1
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            alertDialog(1)
        }
        else if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            alertDialog(2)
        }

        // diagonal 2
        else if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            alertDialog(1)
        }
        else if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            alertDialog(2)
        }

        else if ( ((player1.size)+(player2.size))==9){
            noOnewon()
        }

    }


    fun noOnewon(){

        var mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert_layout,null)


        var won_txt = mDialogView.findViewById<TextView>(R.id.tv_alert_dialog_won_show)


        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)

        var btn_reply = mDialogView.findViewById<Button>(R.id.btn_replay)
        var btn_exit = mDialogView.findViewById<Button>(R.id.btn_exit_app)


        var alert_d_imag = mDialogView.findViewById<ImageView>(R.id.alert_d_imag)
        var alert_dialg_congo = mDialogView.findViewById<TextView>(R.id.alert_dialg_congo)

        alert_d_imag.setImageResource(R.drawable.oops)
        alert_dialg_congo.visibility = View.INVISIBLE

        var tv_alert_dialog_won_show = mDialogView.findViewById<TextView>(R.id.tv_alert_dialog_won_show)
        tv_alert_dialog_won_show.text = "Oops!! No one won"

        var mAlertDialog = mBuilder.show()
        mAlertDialog.setCanceledOnTouchOutside(false)



        btn_exit.setOnClickListener {
            mAlertDialog.dismiss()

            finish()
        }


        btn_reply.setOnClickListener {
            mAlertDialog.dismiss()
            reset()

        }




    }

    fun alertDialog(wonPlayer:Int){

        if (wonPlayer==1) player1Score+=1 else player2Score+=1

        var mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert_layout,null)


        var won_txt = mDialogView.findViewById<TextView>(R.id.tv_alert_dialog_won_show)

        won_txt.text = "Player : $wonPlayer Won"
        tv_chance.text = "Chance of Player: $wonPlayer"


        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)

        var mAlertDialog = mBuilder.show()

        mAlertDialog.setCanceledOnTouchOutside(false)


        var btn_exit = mDialogView.findViewById<Button>(R.id.btn_exit_app)
        btn_exit.setOnClickListener {
            mAlertDialog.dismiss()

            finish()
        }

        var btn_reply = mDialogView.findViewById<Button>(R.id.btn_replay)
        btn_reply.setOnClickListener {
            mAlertDialog.dismiss()
            reset()


        }

        tv_score_player1.text = "Player 1: $player1Score"
        tv_score_player2.text = "Player 2: $player2Score"

        currentPlayer = wonPlayer
    }

    fun reset(){
        player1.clear()
        player2.clear()

        button1.text =""
        button2.text =""
        button3.text =""
        button4.text =""
        button5.text =""
        button6.text =""
        button7.text =""
        button8.text =""
        button9.text =""

        button1.setBackgroundColor(getColor(R.color.btn_default_color))
        button2.setBackgroundColor(getColor(R.color.btn_default_color))
        button3.setBackgroundColor(getColor(R.color.btn_default_color))
        button4.setBackgroundColor(getColor(R.color.btn_default_color))
        button5.setBackgroundColor(getColor(R.color.btn_default_color))
        button6.setBackgroundColor(getColor(R.color.btn_default_color))
        button7.setBackgroundColor(getColor(R.color.btn_default_color))
        button8.setBackgroundColor(getColor(R.color.btn_default_color))
        button9.setBackgroundColor(getColor(R.color.btn_default_color))

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true



    }


    override fun onBackPressed() {
        var mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert_layout,null)


        var won_txt = mDialogView.findViewById<TextView>(R.id.tv_alert_dialog_won_show)


        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)

        var btn_reply = mDialogView.findViewById<Button>(R.id.btn_replay)
        var btn_exit = mDialogView.findViewById<Button>(R.id.btn_exit_app)

        btn_reply.text ="NO"
        btn_exit.text = "YES"

        var alert_d_imag = mDialogView.findViewById<ImageView>(R.id.alert_d_imag)
        var alert_dialg_congo = mDialogView.findViewById<TextView>(R.id.alert_dialg_congo)

        alert_d_imag.setImageResource(R.drawable.exit)
        alert_dialg_congo.visibility = View.INVISIBLE

        var mAlertDialog = mBuilder.show()
        mAlertDialog.setCanceledOnTouchOutside(false)



        btn_exit.setOnClickListener {
            mAlertDialog.dismiss()

            finish()
        }


        btn_reply.setOnClickListener {
            mAlertDialog.dismiss()

        }
    }

}