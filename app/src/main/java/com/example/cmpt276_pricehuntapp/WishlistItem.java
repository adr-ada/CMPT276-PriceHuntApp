package com.example.cmpt276_pricehuntapp;

import android.graphics.Bitmap;

public class WishlistItem {
    private Bitmap photo;
    private String description;

    public WishlistItem(Bitmap photo, String description) {
        this.photo = photo;
        this.description = description;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }
}
