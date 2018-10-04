package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.gayyy);

        Button playButton = findViewById (R.id.play_button);
        playButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "I'm done!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button pauseButton = findViewById (R.id.pause_button);
        pauseButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                mediaPlayer.pause();
            }
        });

    }
}
