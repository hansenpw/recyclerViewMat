package com.mat.sqlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    ItemAdapter adapter;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    private void setUp() {
        rv = (RecyclerView) findViewById(R.id.rvItems);
        //helper = new DBHelper(this);

        List<String> listTitle = new ArrayList<>();
        listTitle.add("Harry Pot");
        listTitle.add("Harry Pot 2");
        listTitle.add("Harry Pot 3");
        listTitle.add("Harry Pot 4");
        listTitle.add("Harry Pot 5");

        adapter = new ItemAdapter(listTitle, MainActivity.this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
