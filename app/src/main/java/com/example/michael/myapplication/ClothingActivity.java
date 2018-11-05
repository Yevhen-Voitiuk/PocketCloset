package com.example.michael.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class ClothingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    List<Entry> clothingList; //switch to wearable later for clothing and outfits
    private final static int ROWS_WIDE = 3;

    private Button returnHomeButton;
    private Button addClothingButton;
    private Button deleteClothingButton;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothing_recyclerview);

        clothingList = new ArrayList<>();
        clothingList.add(new Clothing("Grandma's Clubbing Pants",
                R.drawable.womens_black_jeans));
        clothingList.add(new Clothing("Grandma's Clubbing Top",
                R.drawable.gold_spaghetti_top));
        clothingList.add(new Clothing("Grandma's Clubbing Shoes",
                R.drawable.gold_high_heels));
        clothingList.add(new Clothing("Grandma's Clubbing Earrings",
                R.drawable.grandmas_gold_earrings));
        clothingList.add(new Clothing("Grandma's Clubbing Socks",
                R.drawable.taco_socks));
        clothingList.add(new Clothing("Grandma's Clubbing Pants",
                R.drawable.womens_black_jeans));
        clothingList.add(new Clothing("Grandma's Clubbing Top",
                R.drawable.gold_spaghetti_top));
        clothingList.add(new Clothing("Grandma's Clubbing Shoes",
                R.drawable.gold_high_heels));
        clothingList.add(new Clothing("Grandma's Clubbing Earrings",
                R.drawable.grandmas_gold_earrings));
        clothingList.add(new Clothing("Grandma's Clubbing Socks",
                R.drawable.taco_socks));
        clothingList.add(new Clothing("Grandma's Clubbing Pants",
                R.drawable.womens_black_jeans));
        clothingList.add(new Clothing("Grandma's Clubbing Top",
                R.drawable.gold_spaghetti_top));
        clothingList.add(new Clothing("Grandma's Clubbing Shoes",
                R.drawable.gold_high_heels));
        clothingList.add(new Clothing("Grandma's Clubbing Earrings",
                R.drawable.grandmas_gold_earrings));
        clothingList.add(new Clothing("Grandma's Clubbing Socks",
                R.drawable.taco_socks));


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.clothing_recyclerview_id);
        ClothingRecyclerViewAdapter myAdapter = new ClothingRecyclerViewAdapter(this,clothingList);
        my_recycler_view.setLayoutManager(new GridLayoutManager(this,ROWS_WIDE));
        my_recycler_view.setAdapter(myAdapter);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.allClothingtoolbar_id);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(name);

        drawerLayout = (DrawerLayout) findViewById(R.id.clothingDrawerLayoutId);
        toggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.clothingNavViewId);
        navigationView.setNavigationItemSelectedListener(this);

        dialog = new Dialog(this);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Intent intent;
        switch(id)
        {
            case R.id.home:
                intent = new Intent(ClothingActivity.this,HomePage.class);
                startActivity(intent);
                break;
            case R.id.add:
                View view = menuItem.getActionView();
                showAddClothingPopup(view);
                break;
            case R.id.delete:
                //intent = new Intent(ClothingActivity.this,OutfitActivity.class);
                //startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.clothingDrawerLayoutId);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showAddClothingPopup (View v) {

        TextView txtclose;
        Button btnAdd;
        dialog.setContentView(R.layout.add_clothing_popup);
        txtclose = (TextView) dialog.findViewById(R.id.txtclose);
        btnAdd = (Button) dialog.findViewById(R.id.addButton);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
