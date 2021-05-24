package com.example.slidepuzzle

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Size
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.slidepuzzle.ui.boardoptions.BoardOptionsViewModel
import com.example.slidepuzzle.ui.boardoptions.BoardTitledSize
import com.example.slidepuzzle.ui.game.GameBoard
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

data class BoardActivityParams(val bitmap: Bitmap, val size: BoardTitledSize)

class GameActivity : AppCompatActivity() {
    companion object {
        lateinit var initialConfig: BoardActivityParams
    }
    var counter = 0

    private val viewModel: BoardOptionsViewModel by lazy {
        ViewModelProviders.of(this).get(BoardOptionsViewModel::class.java)
    }

    fun mountBoard() {
        val board = findViewById<GameBoard>(R.id.boardView)

        viewModel.boardSize.observe(this, Observer {
            it?.let {
                board.resize(
                    Size(it.width, it.height),
                    viewModel.boardImage.value
                )
            }
        })

        findViewById<Button>(R.id.shuffle).setOnClickListener {
            board.shuffle()
        }

        findViewById<Button>(R.id.solucion).setOnClickListener {
            board.shuffle(true)
        }

        findViewById<Button>(R.id.end).setOnClickListener {
            Toast.makeText(this, "has tardado " + counter + " segundos", Toast.LENGTH_SHORT).show()
            //Score.scorePoints = " " + Score.scorePoints + "Puntuacion : " + counter + "\n"

           val database = Firebase.database("https://puzzledos-default-rtdb.europe-west1.firebasedatabase.app/")
            val user = Firebase.auth.currentUser;


            if (user != null) {
                val myRef = database.getReference(user.uid)

                myRef.setValue(counter)
            }



            val intent = Intent(this, Gallery::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.apply {
            boardSize.value = initialConfig.size
            boardImage.value = initialConfig.bitmap

        }

        super.onCreate(savedInstanceState)

        setContentView(R.layout.game_activity)
        setSupportActionBar(findViewById(R.id.board_options_toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mountBoard()
        startTimeCounter()
    }

    private fun startTimeCounter() {
        val countTime: TextView = findViewById(R.id.temporizador)
        object : CountDownTimer(1000000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                countTime.text = counter.toString()
                counter++
            }
            override fun onFinish() {
                countTime.text = "Game Over"
            }
        }.start()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

      fun finishGame (view:View){
        counter = 0
    }

    }
