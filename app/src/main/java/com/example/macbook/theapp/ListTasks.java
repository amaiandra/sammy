package com.example.macbook.theapp;

import android.app.Application;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


public class ListTasks extends ListActivity {


    public final static String TASKS_CACHE_FILE = "task_cache.ser";


    Button btn_add;

    private ArrayAdapter ItemArrayAdapter;


    public List<Task> thetasks = new ArrayList<Task>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        btn_add = (Button) findViewById(R.id.btn_add);

        thetasks = Readfiles.action(this);


        ItemArrayAdapter = new TaskAdapter(this, thetasks);
        setListAdapter(ItemArrayAdapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ListTasks.this, AddTask.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        Log.d(ListTasks.class.getSimpleName(), "hola");

        Task task1= thetasks.get(position);
                Intent i = new Intent(this, TaskDetails.class);
                i.putExtra("task",task1);
                i.putExtra("position", position);
                startActivity(i);


    }





}

