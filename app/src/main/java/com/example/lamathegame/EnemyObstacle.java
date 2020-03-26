package com.example.lamathegame;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class EnemyObstacle extends Character {

    public EnemyObstacle(ImageView image, int posX, int posY) {
        super(image, posX, posY);
    }

    //make move the enemyObstacle
    public void move() {
        this.setPosX(this.getPosX() - 10);
        this.setCharacterImageView();
    }
}
