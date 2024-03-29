package com.example.george.children_fruit_and_vegetable_learning_application;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class view_berries extends AppCompatActivity {

    public String[] fruitType = {"Blue Berries","Cherries", "Grapes","Raspberries","Strawberries"};
    public String[] fruitDescription = {"These are Blueberries","These are Cherries","These are Grapes","These are Raspberries","These are Strawberries"};
    public Integer[] image = {R.drawable.berries_blueberry,R.drawable.berries_cherry,R.drawable.berries_grapes,R.drawable.berries_raspberry,R.drawable.berries_strawberry};
    public  ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lst = (ListView) findViewById(R.id.listview);
        typesOfFruitsClass typesOfFruits = new typesOfFruitsClass(this,fruitType,fruitDescription,image);
        lst.setAdapter(typesOfFruits);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Berries");

        //ADDING THE BACK NAVIGATION.

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){

            public  void gettingSpecificFruits(int position){
                Intent intent = new Intent(view_berries.this,single_fruit.class);
                intent.putExtra("name",fruitType[position]);
                intent.putExtra("image",image[position]);
                intent.putExtra("fruitTypes","Berries");
                startActivity(intent);
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position <= 4){
                    gettingSpecificFruits(position);
                }
            }
        };

        lst.setOnItemClickListener(itemClickListener);
    }


}
