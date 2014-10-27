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


   protected void onCreate (Bundle savedInstantState){
       super.onCreate (savedInstantState);
       setContentView(R.layout.activity_task_detail);
       Intent i= getIntent();
       task= (Task) i.getSerializableExtra("task");


       Button btn_delete = (Button) findViewById(R.id.btn_delete);
       Button btn_edit = (Button) findViewById(R.id.btn_edit);
       btn_delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               List<Task> thetasks = new ArrayList<Task>();
               thetasks= readfiles();
               thetasks.remove(task);
               writefiles(thetasks);
               Toast.makeText(getApplicationContext(), "t=)",
                       Toast.LENGTH_SHORT).show();

               Intent i = new Intent(TaskDetails.this, ListTasks.class);
               startActivity(i);
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


    public List readfiles() {
       List<Task> thetasks = new ArrayList<Task>();
        try {

            FileInputStream fis = openFileInput(ListTasks.TASKS_CACHE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            thetasks = (List<Task>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thetasks;
    }

    public void writefiles(List<Task> thetasks){
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
    }



}