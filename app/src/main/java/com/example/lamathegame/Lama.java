package com.example.lamathegame;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Lama extends Character {
    private boolean onJump;

    public Lama(ImageView image, int posX, int posY, int sizeX, int sizeY) {
        super(image, posX, posY, sizeX, sizeY);
        this.onJump = false;
    }

    //make start the walking animation of the lama
    public void startAnimation() {
        AnimationDrawable lamaAnimation = (AnimationDrawable) this.getCharacterImageView().getBackground();
        lamaAnimation.start();
    }

    public void jump() {

    }
}
