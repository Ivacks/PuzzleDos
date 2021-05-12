package com.example.slidepuzzle

import android.support.v7.app.AppCompatActivity
import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.media.MediaPlayer
import android.view.View


class MainActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null


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

        //region ExitButton
        var buttonExit = findViewById<Button>(R.id.btnExit)
        buttonExit.setOnClickListener {
            finishAffinity()
        }
        //endregion

        //endregion


        }

    //region Sound

    // 1. Plays the Background sound
    fun playSound(view: View) {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.gokuforever)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    // 2. Pause playback
    fun pauseSound(view: View) {
        if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) mMediaPlayer!!.pause()
    }

    // 3. {optional} Stops playback
    fun stopSound(view: View) {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    // 4. Closes the MediaPlayer when the app is closed
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
        //endregion


    }
}

