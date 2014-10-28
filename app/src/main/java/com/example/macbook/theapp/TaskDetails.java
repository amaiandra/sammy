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
/**
 * Created by macbook on 10/27/14.
 */
public class TaskDetails extends Activity  {

    Button btn_delete;
    Button btn_edit;
    Task task;
    List<Task> thetasks1 = new ArrayList<Task>();
    int position;



    protected void onCreate (Bundle savedInstantState){
       super.onCreate (savedInstantState);
       setContentView(R.layout.activity_task_detail);
       Intent i= getIntent();
       task= (Task) i.getSerializableExtra("task");
       thetasks1= Readfiles.action(TaskDetails.this);
       i.getIntExtra("position", position);

       Button btn_delete = (Button) findViewById(R.id.btn_delete);
       Button btn_edit = (Button) findViewById(R.id.btn_edit);
       btn_delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               thetasks1.remove(position);

           }
       });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(), "position = " + position,
                        Toast.LENGTH_SHORT).show();


            }
        });



       TextView title = (TextView) findViewById(R.id.descTitle);
       title.setText(task.getTitle());
       TextView description = (TextView) findViewById(R.id.descDes);
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

}