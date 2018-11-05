package com.example.michael.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity{ //implements SearchView.OnQueryTextListener{

    private List<Closet> items;
    private SearchRecyclerViewAdapter myAdapter;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbar = (Toolbar)findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

//        recyclerView = findViewById(R.id.search_recyclerview_id);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//
//        items = new ArrayList<Closet>(Arrays.asList(items));
//                myAdapter = new SearchRecyclerViewAdapter(this,items);
//        recyclerView.setAdapter(myAdapter);

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Lut enim ad minim " +
                "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo " +
                "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum " +
                "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officiae deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lut enim ad minim ";

        items = new ArrayList<>();
        items.add(new Closet("Home Closet", loremIpsum, R.drawable.closet1, 'W'));
        items.add(new Closet("Casual Outfit", loremIpsum, R.drawable.outfit2, 'O'));
        items.add(new Closet("Grandma's Getting Lucky Necklace", loremIpsum, R.mipmap.necklace, 'C'));
        items.add(new Closet("Vacation Home Closet", loremIpsum, R.drawable.closet2, 'W'));
        items.add(new Closet("Button Down Shirt", loremIpsum, R.drawable.shirt1, 'C'));
        items.add(new Closet("Work Outfit", loremIpsum, R.drawable.outfit1, 'O'));
        items.add(new Closet("Pants", loremIpsum, R.drawable.pants, 'C'));
        items.add(new Closet("Home Closet", loremIpsum, R.drawable.closet1, 'W'));
        items.add(new Closet("Casual Outfit", loremIpsum, R.drawable.outfit2, 'O'));
        items.add(new Closet("Vacation Home Closet", loremIpsum, R.drawable.closet2, 'W'));
        items.add(new Closet("Button Down Shirt", loremIpsum, R.drawable.shirt1, 'C'));
        items.add(new Closet("Work Outfit", loremIpsum, R.drawable.outfit1, 'O'));
        items.add(new Closet("Pants", loremIpsum, R.drawable.pants, 'C'));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.search_recyclerview_id);
        myAdapter = new SearchRecyclerViewAdapter(this,items);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_items,menu);
        //MenuItem menuItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) menuItem.getActionView();
        //searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }

//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        String userInput = newText.toLowerCase();
//        List<Closet> newList = new ArrayList<>();
//
//        for(Closet item : items)
//        {
//            if(item.getClosetName().toLowerCase().contains(userInput) || item.getDescription().toLowerCase().contains(userInput)){
//                newList.add(item);
//            }
//        }
//
//        myAdapter.updateList(newList);
//        return true;
//    }
}
