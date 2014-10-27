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
import android.widget.ImageView;
import android.widget.TextView;

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
 * Created by macbook on 10/27/14.
 */
public class TaskDetails extends Activity implements View.OnClickListener {

    Button btn_delete;
    Task task;


   protected void onCreate (Bundle savedInstantState){
       super.onCreate (savedInstantState);
       setContentView(R.layout.activity_task_detail);
       Intent i= getIntent();
       task= (Task) i.getSerializableExtra("task");


       TextView title = (TextView) findViewById(R.id.descTitle);
       title.setText(task.getTitle());
       TextView description = (TextView) findViewById(R.id.descTitle);
       description.setText(task.getDescription());
       ImageView imgbutton = (ImageView) findViewById(R.id.decimageView);
       if(task.getStatus()==1){
           imgbutton.setImageResource(R.drawable.done);
       }
       else {
           imgbutton.setImageResource(R.drawable.notdone);
       }
       final TaskDetails theAdapter = this;
       imgbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               task.setStatus((task.getStatus()+1)%2);

               theAdapter.recreate();

           }
       });


   }


    @Override
    public void onClick(View v) {

    }
}