package com.example.lamathegame;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Jeu  extends AppCompatActivity {
    public DisplayMetrics displayMetrics = new DisplayMetrics();
    public static Integer heightScreen;
    public static Integer widthScreen;
    private Handler handler = new Handler();

    //characters of the game
    private Lama lama;
    private EnemyObstacle scorpion;

    public Integer score = 0;
    public Integer interval = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);

        setScene();

        //lancement de la boucle de jeu
        loopGame();
    }

    private void setScene() {
        //dimension de l'ecran
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        heightScreen = displayMetrics.heightPixels;
        widthScreen = displayMetrics.widthPixels;

        ImageView lamaImageView = (ImageView) findViewById(R.id.lamaImageView);
        ImageView scorpionImageView = (ImageView) findViewById(R.id.scorpionImageView);

        //creation du lama du jeu
        lama = new Lama(lamaImageView, 20, heightScreen - 348, 54, 64);
        lama.startAnimation();
        lama.setCharacterImageView();

        //creation d'un scorpion
        scorpion = new EnemyObstacle(scorpionImageView, widthScreen-80, heightScreen - 327, 70, 57);
        scorpion.setCharacterImageView();

        //draw properly the score
        TextView scores = findViewById(R.id.score);
        RelativeLayout.LayoutParams paramsTextView = (RelativeLayout.LayoutParams) scores.getLayoutParams();
        paramsTextView.topMargin = 100;
        paramsTextView.leftMargin = widthScreen/2 + scores.getWidth();
        scores.setLayoutParams(paramsTextView);
    }

    private void loopGame() {
        refreshGame.run();
    }

    Runnable refreshGame = new Runnable() {
        @Override
        public void run() {
            //make the enemy move and make the score up
            scorpion.move();

            //Test des collisions
            if (Rect.intersects(lama.getRectDimension(), scorpion.getRectDimension())) {
                //TODO
                //GAME OVER, redirect into the Menu Activity and save the score
            }
            else {
                scoreUp();
            }

            //load the next refreshGame in a fixed time
            handler.postDelayed(refreshGame, 20);
        }
    };

    private void scoreUp() {
        interval += 1;
        if (interval % 25 == 0) {
            this.score += 1;
            interval = 0;
        }
        TextView textView = findViewById(R.id.score);
        textView.setText(this.score.toString());
    }
}
