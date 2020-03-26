package com.example.lamathegame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Integer widthScreen = displayMetrics.widthPixels;

        ImageView lamaImageView1 = (ImageView) findViewById(R.id.lamaAnimationMenu1);
        ImageView lamaImageView2 = (ImageView) findViewById(R.id.lamaAnimationMenu2);

        //create two Lamas for the design of the menu
        Lama lama1 = new Lama(lamaImageView1, 75, 100, 128, 128);
        lama1.startAnimation();
        lama1.setCharacterImageView();
        Lama lama2 = new Lama(lamaImageView2, widthScreen - 315, 100, 128, 128);
        lama2.startAnimation();
        lama2.setCharacterImageView();

        //some good sound for the game atmosphere
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
