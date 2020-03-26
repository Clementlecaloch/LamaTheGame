package com.example.lamathegame;

import android.widget.ImageView;

public class EnemyObstacle extends Character {

    public EnemyObstacle(ImageView image, int posX, int posY, int sizeX, int sizeY) {
        super(image, posX, posY, sizeX, sizeY);
    }

    //make move the enemyObstacle
    public void move() {
        if (this.getPosX() < 0) {
            this.setPosX(Jeu.widthScreen - 70);
            this.getRectDimension().set(posX, posY, posX + sizeX, this.posY + sizeY);
        }
        else {
            this.setPosX(this.getPosX() - this.getxDelta());
            this.getRectDimension().set(posX, posY, posX + sizeX, this.posY + sizeY);
        }
        this.setCharacterImageView();
    }
}
