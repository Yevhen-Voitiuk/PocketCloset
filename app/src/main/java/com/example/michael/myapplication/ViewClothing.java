package com.example.michael.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class ViewClothing extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView tvName, tvDescription;
    private ImageView img;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clothing);

        tvName = (TextView) findViewById(R.id.name_id);
        tvDescription = (TextView) findViewById(R.id.description_id);
        //tvSearchTitle = (TextView) findViewById(R.id.toolbar_id);
        img = (ImageView) findViewById(R.id.clothing_thumbnail);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("Name");
        String description = intent.getExtras().getString("Description");
        int image = intent.getIntExtra("Thumbnail", 0);

        tvName.setText(name);
        tvDescription.setText(description);
        //tvSearchTitle.setText(name);
        img.setImageResource(image);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);

        drawerLayout = (DrawerLayout) findViewById(R.id.viewClothingDrawerLayoutId);
        toggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.viewClothingNavId);
        navigationView.setNavigationItemSelectedListener(this);

        dialog = new Dialog(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
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
                intent = new Intent(ViewClothing.this,HomePage.class);
                startActivity(intent);
                break;
            case R.id.edit:
                //intent = new Intent(AddOutfit.this,AddOutfit.class);
                //startActivity(intent);
                View view = menuItem.getActionView();
                showAddClothingPopup(view);
                break;
            case R.id.delete:
                intent = new Intent(ViewClothing.this,ClothingActivity.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.viewClothingDrawerLayoutId);
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
