package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 10/23/14.
 */
public class AddTask extends Activity implements View.OnClickListener {

    EditText Title, Description;
    Button btn_add_accept, btn_add_cancel;
    Task tsk;

    private ArrayAdapter ItemArrayAdapter;


    public List<Task> thetasks = new ArrayList<Task>();




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Title = (EditText) findViewById(R.id.title);
        Description = (EditText) findViewById(R.id.description);
        btn_add_accept = (Button) findViewById(R.id.btn_add_accept);
        btn_add_cancel = (Button) findViewById(R.id.btn_add_cancel);
        btn_add_accept.setOnClickListener(this);
        btn_add_cancel.setOnClickListener(this);


    }

    public void onClick(View v) {
        tsk = new Task();
        String ti = Title.getText().toString();
        String dc = Description.getText().toString();
        if (v ==this.btn_add_accept) {
            if (!ti.isEmpty() && !dc.isEmpty()) {

                try {

                    FileInputStream fis = openFileInput(ListTasks.TASKS_CACHE_FILE);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    thetasks = (List<Task>) ois.readObject();
                    ois.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tsk.setTitle(ti);
                tsk.setDescription(dc);
                tsk.setStatus(0);
                thetasks.add(tsk);
                try {
                    FileOutputStream fos = openFileOutput(ListTasks.TASKS_CACHE_FILE, Context.MODE_PRIVATE);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(thetasks);
                    oos.close();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent i = new Intent(this, ListTasks.class);
                startActivity(i);
            }
        }
        if (v ==this.btn_add_cancel){
            Intent i=new Intent(this,ListTasks.class);
            startActivity(i);
        }

    }


}

