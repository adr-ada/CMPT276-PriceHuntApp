package com.example.cmpt276_pricehuntapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmpt276_pricehuntapp.Adapter.WishlistAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class WishlistActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private ImageView imgPhoto;
    private EditText etDescription;
    private RecyclerView rvItems;
    private ArrayList<WishlistItem> itemList;
    private WishlistAdapter wishlistAdapter;
    private Bitmap selectedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        Button btnAddPhoto = findViewById(R.id.btn_add_photo);
        Button btnSubmit = findViewById(R.id.btn_submit);
        imgPhoto = findViewById(R.id.img_photo);
        etDescription = findViewById(R.id.et_description);
        rvItems = findViewById(R.id.rv_items);

        // Initialize list and adapter
        itemList = new ArrayList<>();
        wishlistAdapter = new WishlistAdapter(itemList);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setAdapter(wishlistAdapter);

        // Add photo button action
        btnAddPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE);
        });

        // Submit button action
        btnSubmit.setOnClickListener(v -> {
            String description = etDescription.getText().toString();
            if (selectedBitmap != null && !description.isEmpty()) {
                // Add the photo and description to the list
                itemList.add(new WishlistItem(selectedBitmap, description));
                wishlistAdapter.notifyDataSetChanged();
                rvItems.setVisibility(View.VISIBLE);

                // Clear the inputs
                imgPhoto.setImageBitmap(null);
                imgPhoto.setVisibility(View.GONE);
                etDescription.setText("");
                selectedBitmap = null;
            } else {
                Toast.makeText(WishlistActivity.this, "Please add a photo and description", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                selectedBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imgPhoto.setImageBitmap(selectedBitmap);
                imgPhoto.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
