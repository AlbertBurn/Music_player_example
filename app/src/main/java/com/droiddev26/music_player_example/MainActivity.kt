package com.droiddev26.music_player_example

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    lateinit var videoView: VideoView
    lateinit var mediaPlayer: MediaPlayer
    lateinit var playButton: Button
    //var playStatus :Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById<Button>(R.id.playButton)
        mediaPlayer = MediaPlayer.create(this, R.raw.audio)
    }

    fun play(view: View) {
        if (mediaPlayer.isPlaying()) {
            pause()
            //playStatus = true
            playButton.setText("Pause")
        } else {
            play()
            //playStatus = false
            playButton.setText("Play")
        }

    }

    fun play() {
        mediaPlayer.start()
    }

    fun pause() {
        mediaPlayer.pause()
    }
}