package com.example.loginapp;

import android.os.Parcel;
import android.os.Parcelable;

public class WishlistItem implements Parcelable {
    private String imagePath;
    private String description;

    public WishlistItem(String imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;
    }

    protected WishlistItem(Parcel in) {
        imagePath = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagePath);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WishlistItem> CREATOR = new Creator<WishlistItem>() {
        @Override
        public WishlistItem createFromParcel(Parcel in) {
            return new WishlistItem(in);
        }

        @Override
        public WishlistItem[] newArray(int size) {
            return new WishlistItem[size];
        }
    };

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }
}