package com.example.slidepuzzle

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Bitmap
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.util.Size
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.slidepuzzle.ui.boardoptions.BoardOptionsViewModel
import com.example.slidepuzzle.ui.boardoptions.BoardTitledSize
import com.example.slidepuzzle.ui.game.GameBoard
import com.example.slidepuzzle.ui.game.ScoreBoard
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.puntuacion.*


class Score : AppCompatActivity() {

    var puntuacion = GameActivity.initialConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puntuacion)

        tv_puntuacion = findViewById(R.id.tv_puntuacion)

        tv_puntuacion.text = "Puntuacion = $puntuacion"
    }
}

