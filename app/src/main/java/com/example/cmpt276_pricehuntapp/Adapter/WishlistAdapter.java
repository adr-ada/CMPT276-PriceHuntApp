package com.example.cmpt276_pricehuntapp.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmpt276_pricehuntapp.R;
import com.example.cmpt276_pricehuntapp.WishlistItem;

import java.util.ArrayList;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder> {

    private ArrayList<WishlistItem> itemList;

    public WishlistAdapter(ArrayList<WishlistItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wishlist, parent, false);
        return new WishlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistViewHolder holder, int position) {
        WishlistItem item = itemList.get(position);
        Bitmap bitmap = BitmapFactory.decodeFile(item.getImagePath());
        holder.imgPhoto.setImageBitmap(bitmap);
        holder.tvDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class WishlistViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvDescription;

        public WishlistViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}