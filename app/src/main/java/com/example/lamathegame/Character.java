package com.example.lamathegame;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Character {
    private RelativeLayout.LayoutParams params;
    private ImageView CharacterImageView;
    private int posX;
    private int posY;
    private int xDelta = 10;
    private int yDelta = 10;

    public Character(ImageView image, int posX, int posY) {
        this.CharacterImageView = image;
        this.params = (RelativeLayout.LayoutParams) this.CharacterImageView.getLayoutParams();
        this.posX = posX;
        this.posY = posY;
    }

    public void setCharacterImageView() {
        params.leftMargin = posX;
        params.topMargin = posY;
        this.CharacterImageView.setLayoutParams(params);
    }

    public ImageView getCharacterImageView() {
        return CharacterImageView;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.getPosY();
    }

    public int getxDelta() {
        return this.xDelta;
    }

    public int getyDelta() {
        return this.yDelta;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
