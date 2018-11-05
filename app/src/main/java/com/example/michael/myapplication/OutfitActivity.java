package com.example.michael.myapplication;

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

import java.util.ArrayList;
import java.util.List;



public class OutfitActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    List<Entry> outfitList; //switch to wearable later for clothing and outfits
    private final static int ROWS_WIDE = 3;

    private Button returnHomeButton;
    private Button addClothingButton;
    private Button deleteClothingButton;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfit_recyclerview);

        outfitList = new ArrayList<>();

        outfitList.add(new Outfit("Grandma's Formal Clothes", R.drawable.closet2));
        outfitList.add(new Outfit("Grandma's Easter Mass Outfit", R.drawable.easter_mass_outfit));
        outfitList.add(new Outfit("Grandma's Spring Attire", R.drawable.outfit1));
        outfitList.add(new Outfit("Grandma's Casual Wear", R.drawable.outfit2));
        outfitList.add(new Outfit("Grandma's Happy Day", R.drawable.happy_outfit));
        outfitList.add(new Outfit("Grandma's Clubbing Outfit", R.drawable.clubbing_outfit));
        outfitList.add(new Outfit("Grandma's Cookie Baking Outfit", R.drawable.grandmas_cooking_outfit));
        outfitList.add(new Outfit("Grandma's Breakdance Gear", R.drawable.grandmas_breakdance_gear));
        outfitList.add(new Outfit("Grandma's Fire Fighter Outfit", R.drawable.firefighter_outfit));
        outfitList.add(new Outfit("Grandma's Graduation Gown", R.drawable.graduation_gown));
        outfitList.add(new Outfit("Grandma's Halloween 2018", R.drawable.halloween_outfit));


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.outfit_recyclerview_id);
        OutfitRecyclerViewAdapter myAdapter = new OutfitRecyclerViewAdapter(this,outfitList);
        my_recycler_view.setLayoutManager(new GridLayoutManager(this,ROWS_WIDE));
        my_recycler_view.setAdapter(myAdapter);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.outfitstoolbar_id);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(name);

        drawerLayout = (DrawerLayout) findViewById(R.id.outfitsDrawerLayoutId);
        toggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.outfitsNavViewId);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
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
                intent = new Intent(OutfitActivity.this,HomePage.class);
                startActivity(intent);
                break;
            case R.id.add:
                intent = new Intent(OutfitActivity.this,ClothingActivity.class);
                startActivity(intent);
                break;
            case R.id.delete:
                intent = new Intent(OutfitActivity.this,OutfitActivity.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.outfitsDrawerLayoutId);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
