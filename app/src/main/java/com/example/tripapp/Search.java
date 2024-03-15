package com.example.tripapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Search extends AppCompatActivity {

    RecyclerView recyclerViewsearch;
    ArrayList<ModelSearch> list = new ArrayList<>();
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();

        recyclerViewsearch = findViewById(R.id.RecycleViewSearch);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        list.add(new ModelSearch(R.drawable.chail, "BHIMTAL", "nvhjbjhbj"));
        list.add(new ModelSearch(R.drawable.bhimtal,"MANALI", "nvhjbjhbj"));
        list.add(new ModelSearch(R.drawable.bhimtal,"SHIMLA", "nvhjbjhbj"));
        list.add(new ModelSearch(R.drawable.bhimtal,"COW", "nvhjbjhbj"));
        list.add(new ModelSearch(R.drawable.bhimtal,"DOG", "nvhjbjhbj"));
        list.add(new ModelSearch(R.drawable.bhimtal,"DEER", "nvhjbjhbj"));

        AdapterSearch adapterSearch = new AdapterSearch(getApplicationContext(), list);
        recyclerViewsearch.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewsearch.setAdapter(adapterSearch);

        //searchview

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String newText) {
        ArrayList<ModelSearch> filterList = new ArrayList<ModelSearch>();
        for(ModelSearch modelSearch : list) {
            if(modelSearch.getTitle().toLowerCase().contains(newText.toLowerCase())) {
                filterList.add(modelSearch);
            }
        }
        if(filterList.isEmpty()) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
        else {
            AdapterSearch adapterSearch = new AdapterSearch(getApplicationContext(), filterList);
            recyclerViewsearch.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerViewsearch.setAdapter(adapterSearch);
        }
    }
}