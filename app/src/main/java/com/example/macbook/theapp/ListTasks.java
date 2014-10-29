package com.example.macbook.theapp;

import android.app.Application;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
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


    Intent f = getIntent();
    String username = f.getStringExtra( "username");
    public final String TASKS_CACHE_FILE = "task_cache_" + username +".ser";




    private ArrayAdapter ItemArrayAdapter;


    public List<Task> thetasks = new ArrayList<Task>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_logout = (Button) findViewById(R.id.btn_signout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListTasks.this, Login.class);
                startActivity(i);
            }
        });
        ImageButton btn_change = (ImageButton) findViewById(R.id.btn_chng);
          btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassicSingleton.getInstance();
                if(ClassicSingleton.getInstance().isWoman()){
                    ClassicSingleton.getInstance().setMan();
                    Toast.makeText(getApplicationContext(), "Sammy is now a man",
                            Toast.LENGTH_SHORT).show();                }
                else if (ClassicSingleton.getInstance().isMan()){
                    Toast.makeText(getApplicationContext(), "Sammy went home",
                            Toast.LENGTH_SHORT).show();
                    ClassicSingleton.getInstance().setNone();
                }
                else {
                    ClassicSingleton.getInstance().setWoman();
                    Toast.makeText(getApplicationContext(), "Sammy is now a girl",
                            Toast.LENGTH_SHORT).show(); Toast.makeText(getApplicationContext(), "Sammy is now a girl",
                            Toast.LENGTH_SHORT).show();
                }



            }
        });


        thetasks = Readfiles.action(this,TASKS_CACHE_FILE);


        ItemArrayAdapter = new TaskAdapter(this, thetasks);
        setListAdapter(ItemArrayAdapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ListTasks.this, AddTask.class);
                i.putExtra("file", TASKS_CACHE_FILE);
                startActivity(i);
            }
        });


    }


    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {

        Task task1= thetasks.get(position);
                Intent i = new Intent(this, TaskDetails.class);
                i.putExtra("task",task1);
                i.putExtra("position", position);
                i.putExtra("file", TASKS_CACHE_FILE);
                startActivity(i);


    }





}

