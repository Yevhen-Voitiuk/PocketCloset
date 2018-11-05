package com.example.michael.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class OneClosetActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    List<Clothing> wearableList; //switch to wearable later for clothing and outfits
    private final static int ROWS_WIDE = 3;

    private CardView outfitCard;
    private Button returnHomeButton;
    private Button addClothingButton;
    private Button deleteClothingButton;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_recyclerview_layout);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("Name");
        char j = intent.getExtras().getChar("J");
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.allClosetsToobar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);


        wearableList = new ArrayList<>();
        if(j == 'J')
        {
            wearableList.add(new Clothing("Grandma Clubbing", R.mipmap.image1));
            wearableList.add(new Clothing("Grandma's Cookie Baking Outfit", R.mipmap.image2));
            wearableList.add(new Clothing("Grandma's Breakdance Gear", R.mipmap.image3));
            wearableList.add(new Clothing("Grandma's Fire Fighter Outfit", R.mipmap.image4));

        }
        else
        {
            wearableList.add(new Clothing("Grandma's Clubbing Outfit", R.drawable.clubbing_outfit));
            wearableList.add(new Clothing("Grandma's Cookie Baking Outfit", R.drawable.grandmas_cooking_outfit));
            wearableList.add(new Clothing("Grandma's Breakdance Gear", R.drawable.grandmas_breakdance_gear));
            wearableList.add(new Clothing("Grandma's Fire Fighter Outfit", R.drawable.firefighter_outfit));
            wearableList.add(new Clothing("Grandma's Graduation Gown", R.drawable.graduation_gown));
            wearableList.add(new Clothing("Grandma's Halloween 2018", R.drawable.halloween_outfit));
            wearableList.add(new Clothing("Grandma's Bad Mood Outfit", R.drawable.teacher_outfit));
            wearableList.add(new Clothing("Grandma's Formal Clothes", R.drawable.closet2));
            wearableList.add(new Clothing("Grandma's Easter Mass Outfit", R.drawable.easter_mass_outfit));
            wearableList.add(new Clothing("Grandma's Spring Attire", R.drawable.outfit1));
            wearableList.add(new Clothing("Grandma's Casual Wear", R.drawable.outfit2));
            wearableList.add(new Clothing("Grandma's Happy New Year", R.drawable.happy_outfit));
        }


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.closet_recyclerview_id);
        OneClosetRecyclerViewAdapter myAdapter = new OneClosetRecyclerViewAdapter(this,wearableList);
        my_recycler_view.setLayoutManager(new GridLayoutManager(this,ROWS_WIDE));
        my_recycler_view.setAdapter(myAdapter);

        drawerLayout = (DrawerLayout) findViewById(R.id.allClosetsDrawerLayoutId);
        toggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.allClosetsNavViewId);
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
                intent = new Intent(OneClosetActivity.this,HomePage.class);
                startActivity(intent);
                break;
            case R.id.add:
                intent = new Intent(OneClosetActivity.this,ClothingActivity.class);
                startActivity(intent);
                break;
            case R.id.delete:
                intent = new Intent(OneClosetActivity.this,OutfitActivity.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.allClosetsDrawerLayoutId);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
