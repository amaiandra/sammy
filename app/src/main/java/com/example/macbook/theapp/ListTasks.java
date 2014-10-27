package com.example.macbook.theapp;

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



        try {
            FileInputStream fis = openFileInput(TASKS_CACHE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            thetasks = (List<Task>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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


        Toast.makeText(getApplicationContext(), "this is my Toast message!!! =)",
                Toast.LENGTH_SHORT).show();
        Task task1= thetasks.get(position);
                Intent i = new Intent(this, TaskDetails.class);
                i.putExtra("task",task1);
                startActivity(i);


    }



    /*private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener(){
        public void onItemClick (AdapterView<?> parent, View view , int position, long id){
            Intent i = new Intent(ListTasks.this, TaskDetails.class);

            i.putExtra(TASKS_CACHE_FILE, String.valueOf(id));
            startActivity(i);
        }

    };*/
}

