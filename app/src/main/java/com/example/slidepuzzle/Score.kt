package com.example.slidepuzzle


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puntuacion)

        val database = Firebase.database("https://puzzledos-default-rtdb.europe-west1.firebasedatabase.app/").reference
        database.get().addOnSuccessListener {
            var tv_puntos = findViewById<TextView>(R.id.tv_puntos)
            tv_puntos.text=  it.value.toString()
            Log.i("firebase", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }

    }
}


        /*
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
}*/
