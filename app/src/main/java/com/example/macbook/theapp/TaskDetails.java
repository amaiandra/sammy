package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by macbook on 10/27/14.
 */
public class TaskDetails extends Activity  {


    Task task;
    List<Task> thetasks = new ArrayList<Task>();
    int position;



    protected void onCreate (Bundle savedInstantState){
       super.onCreate (savedInstantState);
       setContentView(R.layout.activity_task_detail);
       Intent i= getIntent();
       task= (Task) i.getSerializableExtra("task");
       thetasks= Readfiles.action(TaskDetails.this);
       position = i.getIntExtra("position",0 );

       Button btn_delete = (Button) findViewById(R.id.btn_delete);
       Button btn_edit = (Button) findViewById(R.id.btn_edit);
       Button btn_return = (Button) findViewById(R.id.btn_return);
       btn_delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               thetasks.remove(position);
               Writefiles.action(TaskDetails.this, thetasks);
               Intent i = new Intent(TaskDetails.this, ListTasks.class);
               startActivity(i);

           }
       });
       btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TaskDetails.this, TaskEdit.class);
                i.putExtra("task",task);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

        btn_return.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TaskDetails.this, ListTasks.class);
                startActivity(i);
            }
        });



       TextView title = (TextView) findViewById(R.id.descTitle);
       title.setText(task.getTitle());
       TextView brfdescription = (TextView) findViewById(R.id.brfDesc);
       brfdescription.setText(task.getBriefDescription());
       TextView description = (TextView) findViewById(R.id.Desc);
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
               task.setStatus((task.getStatus() + 1) % 2);
               theAdapter.recreate();
               thetasks.remove(position);
               thetasks.add(position,task);
               Writefiles.action(TaskDetails.this, thetasks);
           }
       });

   }

}