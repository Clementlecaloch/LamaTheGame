package com.example.lamathegame;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Character {
    private ImageView imagePersonnage;

    public Character(ImageView image) {
        this.imagePersonnage = image;
    }

    public ImageView getImagePersonnage() {
        return imagePersonnage;
    }
}
