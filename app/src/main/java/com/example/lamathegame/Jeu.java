package com.example.lamathegame;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Jeu  extends AppCompatActivity {
    private Handler handler = new Handler();
    private Integer score = 0;

    //characters of the game
    private Lama lama;
    private EnemyObstacle scorpion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);

        //dimension de l'ecran
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightScreen = displayMetrics.heightPixels;
        int widthScreen = displayMetrics.widthPixels;

        ImageView lamaImageView = (ImageView) findViewById(R.id.lamaImageView);
        ImageView scorpionImageView = (ImageView) findViewById(R.id.scorpionImageView);

        //creation du lama du jeu
        lama = new Lama(lamaImageView, 20, heightScreen - 348);
        lama.startAnimation();
        lama.setCharacterImageView();

        //creation d'un scorpion
        scorpion = new EnemyObstacle(scorpionImageView, widthScreen-77, heightScreen - 327);
        scorpion.setCharacterImageView();

        //lancement de la boucle de jeu
        loopGame();
    }

    Runnable refreshGame = new Runnable() {
        @Override
        public void run() {
            //make the enemy move and make the score up
            scorpion.move();
            scoreUp();

            handler.postDelayed(refreshGame, 10);
        }
    };

    private void loopGame() {
        refreshGame.run();
    }

    private void scoreUp() {
        this.score += 1;
    }
}
