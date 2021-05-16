package com.example.slidepuzzle

import android.support.v7.app.AppCompatActivity
import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //region Buttons

        //region HistoryModeButton
        var buttonHistoryMode = findViewById<Button>(R.id.ButtonHistoryMode)
        buttonHistoryMode.setOnClickListener {
            val intent = Intent(this, BoardOptionsActivity::class.java)
            startActivity(intent)
        }
        //endregion

        //region GalleryButton
        var buttonGallery = findViewById<Button>(R.id.ButtonGallery)
        buttonGallery.setOnClickListener {
            val intent = Intent(this, Gallery::class.java)
            startActivity(intent)
        }
        //endregion

        //region ConfigurationButton
        var buttonConfiguration = findViewById<Button>(R.id.ButtonConfiguration)
        buttonConfiguration.setOnClickListener {
            val intent = Intent(this, ConfigurationActivity::class.java)
            startActivity(intent)
        }
        //endregion

        //region ScoreButton
        var buttonScore = findViewById<Button>(R.id.ButtonScore)
        buttonScore.setOnClickListener {
            val intent = Intent(this, Score::class.java)
            startActivity(intent)
        }
        //endregion

        //region AboutUsButton
        var buttonAboutUs = findViewById<Button>(R.id.ButtonAboutUs)
        buttonAboutUs.setOnClickListener {
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }
        //endregion

        //region hacer foto
        var buttonHacerFoto = findViewById<Button>(R.id.ButtonHacerFoto)
        buttonHacerFoto.setOnClickListener {
            val intent = Intent(this, HacerFoto::class.java)
            startActivity(intent)
        }
        //endregion

        //region ExitButton
        var buttonExit = findViewById<Button>(R.id.btnExit)
        buttonExit.setOnClickListener {
            finishAffinity()
        }
        //endregion

        //endregion


    }
}

