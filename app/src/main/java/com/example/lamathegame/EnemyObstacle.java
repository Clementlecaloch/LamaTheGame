package com.example.lamathegame;

import android.widget.ImageView;

public class EnemyObstacle extends Character {
    public int xDelta = 20;

    public EnemyObstacle(ImageView image, int posX, int posY, int sizeX, int sizeY) {
        super(image, posX, posY, sizeX, sizeY);
    }

    //make move the enemyObstacle
    public void move() {
        if (posX < -sizeX) {
            posX = Jeu.widthScreen - 150;
        }
        else {
            posX = posX - xDelta;
        }
        this.getRectDimension().set(posX, posY, posX + sizeX, posY + sizeY);
        this.setCharacterImageView();
    }
}
