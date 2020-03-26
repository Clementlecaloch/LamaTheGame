package com.example.lamathegame;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.os.Handler;

public class Lama extends Character {
    private Handler handler = new Handler();
    private int jumpCount;
    private int yDelta = 20;
    private  int maxDeltaYJump = 50;

    public Lama(ImageView image, int posX, int posY, int sizeX, int sizeY) {
        super(image, posX, posY, sizeX, sizeY);
        jumpCount = -1;
    }

    //make start the walking animation of the lama
    public void startAnimation() {
        AnimationDrawable lamaAnimation = (AnimationDrawable) this.getCharacterImageView().getBackground();
        lamaAnimation.start();
    }

    public void launchJump() {
        this.jumpCount = 0;
        jump.run();
    }

    public boolean onJump() {
        if (jumpCount >= 0 && jumpCount < maxDeltaYJump) {
            return true;
        }
        return false;
    }

    public Runnable jump = new Runnable() {
        @Override
        public void run() {
            if (jumpCount < maxDeltaYJump/2) {
                posY -= yDelta;
                jumpCount++;
            }
            else {
                posY += yDelta;
                jumpCount++;
            }
            getRectDimension().set(posX, posY, posX + sizeX, posY + sizeY);
            setCharacterImageView();

            if (onJump()) {
                handler.postDelayed(jump, 10);
            }
        }
    };
}
