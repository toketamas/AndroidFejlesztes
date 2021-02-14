package com.example.karbantartas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView table;
    List<Gep> gepek;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gepek=new LinkedList<>();

        table=findViewById(R.id.grid);
        //table.setNumColumns(6);
        table.setAdapter((ListAdapter) gepek);


    }
}