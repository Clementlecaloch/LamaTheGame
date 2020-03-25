package com.example.lamathegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ImageView lamaImageView = (ImageView) findViewById(R.id.lamaAnimationMenu);
        lamaImageView.setBackgroundResource(R.drawable.lama_animation);
        AnimationDrawable lamaAnimation = (AnimationDrawable) lamaImageView.getBackground();
        lamaAnimation.start();

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
