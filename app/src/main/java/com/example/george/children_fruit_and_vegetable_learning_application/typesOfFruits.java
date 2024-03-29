package com.example.george.children_fruit_and_vegetable_learning_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class typesOfFruits extends AppCompatActivity {
    String[] fruitType = {"Berries", "Citrus Fruits","Melons","Tropical Fruits","Stone Fruits","Tomatoes And Avocadoes"};
    String[] fruitDescription = {"These are Fruits that Are Berries In Nature","These are Fruits that have Vitamin C also Ascorbic Acid","These are Fruits that Are Mellony in nature","These are Fruits that are found in tropical regions","These are Fruits that are Stony","These are Fruits that Avocadoes"};
    Integer[] image = {R.drawable.berries, R.drawable.citrusfruits, R.drawable.melons,R.drawable.tropicalfruits,R.drawable.stonefruits,R.drawable.tomatoesandavocadoes};
    Class[] classes = {view_berries.class,view_citrus.class,view_melons.class,view_tropical_fruits.class,view_stone.class};
    ListView lst;
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Fruit Groupings");

        //setting the action bar so that the up functionality can be implemented.
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        lst = (ListView) findViewById(R.id.listview);
        typesOfFruitsClass typesOfFruits = new typesOfFruitsClass(this,fruitType,fruitDescription,image);
        lst.setAdapter(typesOfFruits);

        //This is the code that wil allow individuals to click on items in the listView and they are taken to the repective pages.

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position<=5){
                    Intent intent = new Intent(typesOfFruits.this,classes[position]);
                    startActivity(intent);
                }
            }
        };

        lst.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.seeAll:
                Intent intent = new Intent(this, allFruits.class);
                startActivity(intent);
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
