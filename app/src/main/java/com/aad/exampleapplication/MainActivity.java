package com.aad.exampleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String place = getIntent().getStringExtra("PlaceName");

        getSupportActionBar().setTitle(place);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Animal> animals = getListData();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(this, animals));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private  List<Animal> getListData() {
        List<Animal> list = new ArrayList<Animal>();

        //добавление животных в список места
        list.add(new Animal("Bear"));
        list.add(new Animal("Squirrel"));

        return list;
    }
}