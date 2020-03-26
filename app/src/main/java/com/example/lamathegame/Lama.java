package com.example.lamathegame;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Lama extends Character {
    private boolean onJump;

    public Lama(ImageView image, int posX, int posY) {
        super(image, posX, posY);
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
