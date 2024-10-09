package com.example.cmpt276_pricehuntapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmpt276_pricehuntapp.Adapter.WishlistAdapter;

import java.util.ArrayList;

public class WishlistActivity extends AppCompatActivity {

    private RecyclerView rvItems;
    private ArrayList<WishlistItem> itemList;
    private WishlistAdapter wishlistAdapter;

    //Initialize user interface and data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        rvItems = findViewById(R.id.rv_items);

        // Get the item list from the intent
        itemList = getIntent().getParcelableArrayListExtra("itemList");
        if (itemList == null) {
            itemList = new ArrayList<>();
        }

        // Initialize adapter
        wishlistAdapter = new WishlistAdapter(itemList);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setAdapter(wishlistAdapter);
    }
}