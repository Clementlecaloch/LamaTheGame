package com.example.lamathegame;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.io.IOException;

public class Jeu extends AppCompatActivity {
    public boolean playing;
    public DisplayMetrics displayMetrics = new DisplayMetrics();
    public static Integer heightScreen;
    public static Integer widthScreen;
    private Handler handler = new Handler();
    private Scores scoresManagement = new Scores(Jeu.this);

    //characters of the game
    private Lama lama;
    private EnemyObstacle scorpion;

    public Integer score = 0;
    public Integer interval = 0;

    MediaPlayer sound;
    MediaPlayer death;

    ImageView soundOff;
    private boolean soundIsOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);

        //draw the scene of the game at his beginning
        setScene();

        //sounds
        sound = MediaPlayer.create(getApplicationContext(),R.raw.super_soundtrack);
        death = MediaPlayer.create(getApplicationContext(),R.raw.foghi);

        RelativeLayout screen = findViewById(R.id.screen);
        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lama.onJump()) {
                    lama.launchJump();
                }
            }
        });

        soundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(soundIsOn) {
                    sound.pause();
                    soundIsOn = false;
                    Resources res = getResources();
                    Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.soundoff, null);
                    soundOff.setBackground(drawable);
                } else {
                    sound.start();
                    soundIsOn = true;
                    Resources res = getResources();
                    Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.soundison, null);
                    soundOff.setBackground(drawable);
                }
            }
        });

        //launch the loopGame
        loopGame();
    }

    private void setScene() {
        //screen dimension
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        heightScreen = displayMetrics.heightPixels;
        widthScreen = displayMetrics.widthPixels;

        ImageView lamaImageView = (ImageView) findViewById(R.id.lamaImageView);
        ImageView scorpionImageView = (ImageView) findViewById(R.id.scorpionImageView);

        soundOff = (ImageView) findViewById(R.id.sound);

        //lama draw
        lama = new Lama(lamaImageView, 20, heightScreen - 348, 54, 64);
        lama.startAnimation();
        lama.setCharacterImageView();

        //scorpion draw
        scorpion = new EnemyObstacle(scorpionImageView, widthScreen-150, heightScreen - 327, 70, 57);
        scorpion.setCharacterImageView();

        //draw properly the score
        TextView scores = findViewById(R.id.score);
        scores.setTextSize(20);
        RelativeLayout.LayoutParams paramsTextView = (RelativeLayout.LayoutParams) scores.getLayoutParams();
        paramsTextView.topMargin = 100;
        paramsTextView.leftMargin = widthScreen/2 + scores.getWidth();
        scores.setLayoutParams(paramsTextView);
    }

    private void loopGame() {
        playing = true;
        sound.start();
        refreshGame.run();
    }

    Runnable refreshGame = new Runnable() {
        @Override
        public void run() {
            //make the enemy move and make the score up
            if(playing) {
                scorpion.move();

                //Test des collisions
                if (Rect.intersects(lama.getRectDimension(), scorpion.getRectDimension())) {
                    sound.stop();
                    death.start();
                    playing = false;

                    //save score
                    String scoreText = score.toString();
                    try {
                        scoresManagement.addScore(scoreText);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //redirection to the menu
                    Intent intent = new Intent(Jeu.this, Menu.class);
                    startActivity(intent);
                }
                else {
                    scoreUp();
                }

                //load the next refreshGame in a fixed time
                handler.postDelayed(refreshGame, 20);
            }
        }
    };

    private void scoreUp() {
        interval += 1;
        if (interval % 25 == 0) {
            this.score += 1;
            interval = 0;
        }
        TextView scores = findViewById(R.id.score);
        scores.setText("Score : " + this.score.toString());
    }
}
