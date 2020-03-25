package com.example.lamathegame;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Lama extends Character {
    boolean onJump;

    public Lama(ImageView image) {
        super(image);
    }

    public void startAnimation() {
        AnimationDrawable lamaAnimation = (AnimationDrawable) this.getImagePersonnage().getBackground();
        lamaAnimation.start();
    }

    public void jump() {

    }
}
