package com.example.lamathegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        MediaPlayer sound = MediaPlayer.create(getApplicationContext(), R.raw.super_soundtrack);
        sound.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaPlayer sound = MediaPlayer.create(getApplicationContext(), R.raw.super_soundtrack);
        sound.stop();
    }

    public void play(View view) {
        Intent intent = new Intent(Menu.this, Jeu.class);
        startActivity(intent);
    }

    public void displayScores(View view) {
        Intent intent = new Intent(Menu.this, Scores.class);
        startActivity(intent);
    }
}
