package com.example.lamathegame;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class Jeu  extends AppCompatActivity {
    Lama lama;
    EnnemyObstacle scorpion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);

        Timer timer = new Timer();
        ImageView lamaImageView = (ImageView) findViewById(R.id.lamaImageView);
        ImageView scorpionImageView = (ImageView) findViewById(R.id.scorpionImageView);

        //creation du lama du jeu
        lama = new Lama(lamaImageView);
        lama.startAnimation();

        //creation d'un scorpion
        scorpion = new EnnemyObstacle(scorpionImageView);
    }
}
