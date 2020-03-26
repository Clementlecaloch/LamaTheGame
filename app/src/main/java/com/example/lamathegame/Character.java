package com.example.lamathegame;

import android.graphics.Rect;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Character {
    private RelativeLayout.LayoutParams params;
    private ImageView CharacterImageView;
    public int posX;
    public int posY;
    public int sizeX;
    public int sizeY;
    private Rect rectDimension;

    public Character(ImageView image, int posX, int posY, int sizeX, int sizeY) {
        this.CharacterImageView = image;
        this.params = (RelativeLayout.LayoutParams) this.CharacterImageView.getLayoutParams();
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.rectDimension = new Rect(posX, posY, posX + sizeX, posY + sizeY);
    }

    public void setCharacterImageView() {
        params.leftMargin = rectDimension.left;
        params.topMargin = rectDimension.top;
        this.CharacterImageView.setLayoutParams(params);
    }

    public ImageView getCharacterImageView() {
        return CharacterImageView;
    }

    public Rect getRectDimension() {
        return rectDimension;
    }
}
