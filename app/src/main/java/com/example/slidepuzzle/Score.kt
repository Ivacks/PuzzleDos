package com.example.slidepuzzle


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Score : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puntuacion)
        var tv_puntos = findViewById<TextView>(R.id.tv_puntos)
        tv_puntos.text = scorePoints
    }
    //    fun checkForWonGame(): Boolean {
//        val wonGame = _dataGrid.gameIsWon()
//        if (wonGame) _gameFinished = true
//        return wonGame
//    }
    companion object {
        var scorePoints : String = ""
    }
}
