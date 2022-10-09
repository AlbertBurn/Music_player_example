package com.droiddev26.music_player_example

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity(), OnSeekBarChangeListener {

    lateinit var mediaPlayer: MediaPlayer
    lateinit var playButton: Button
    lateinit var volumeSeekBar: SeekBar
    lateinit var audioManager: AudioManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        var maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        mediaPlayer = MediaPlayer.create(this, R.raw.audio)
        playButton = findViewById<Button>(R.id.playButton)
        volumeSeekBar = findViewById(R.id.volumeSeekBar)
        volumeSeekBar.setMax(maxVolume)
        volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                Log.i("TAG" , progress.toString())
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }
        })
    }

    fun play(view: View) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause()
            //playStatus = true
            playButton.setText("Play")
        } else {
            mediaPlayer.start()
            //playStatus = false
            playButton.setText("Pause")
        }

    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        Log.i("TAG2" , p1.toString())
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        TODO("Not yet implemented")
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        TODO("Not yet implemented")
    }
}