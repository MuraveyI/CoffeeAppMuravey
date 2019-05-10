package com.muravey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<CoffeeModel> coffeesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =  findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        coffeesList = new  ArrayList<>();
        coffeesList.add(new CoffeeModel(R.drawable.latte, "Latte", "USA", "1,87"));
        coffeesList.add(new CoffeeModel(R.drawable.cappucino, "Cappuccino", "USA", "1,72"));
        coffeesList.add(new CoffeeModel(R.drawable.flatwhite,"Flat White", "USA", "2,44"));
        coffeesList.add(new CoffeeModel(R.drawable.americano, "Americano", "USA", "1,44"));
        coffeesList.add(new CoffeeModel(R.drawable.frapucino, "Frappuccino", "USA", "2,58"));
        coffeesList.add(new CoffeeModel(R.drawable.mocha, "Mocha", "USA", "2,01"));
        coffeesList.add(new CoffeeModel(R.drawable.kemex, "Kemex", "USA", "2,01"));
        coffeesList.add(new CoffeeModel(R.drawable.raf, "Raf", "USA", "2,44"));



        CoffeeAdapter adapter = new CoffeeAdapter(coffeesList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(new CoffeeAdapter.ClickListener() {
            @Override
            public void onClick(int position) {
                CoffeeModel coffeeModel = coffeesList.get(position);
                Intent intent = new Intent(MainActivity.this, LatteCoffee.class);
                intent.putExtra("coffee", coffeeModel);
                startActivity(intent);

            }
        });
    }
}


