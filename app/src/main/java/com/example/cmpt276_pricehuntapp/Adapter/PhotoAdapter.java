package com.example.cmpt276_pricehuntapp.Adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmpt276_pricehuntapp.R;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private ArrayList<Bitmap> photoList;

    public PhotoAdapter(ArrayList<Bitmap> photoList) {
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.imgPhoto.setImageBitmap(photoList.get(position));
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
