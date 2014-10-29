package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 10/28/14.
 */
public class TaskEdit extends Activity {


    Task task;
    List<Task> thetasks = new ArrayList<Task>();
    int position;
    String nTitle, nBrfD, nDesc;



    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_task_edit);
        Intent i = getIntent();
        task = (Task) i.getSerializableExtra("task");
        thetasks = Readfiles.action(TaskEdit.this);
        position = i.getIntExtra("position", 0);
        final String title = task.getTitle();
        final String brfD = task.getBriefDescription();
        final String desc = task.getDescription();
        final EditText eTitle = (EditText) findViewById(R.id.editTitle);
        final EditText eBrfD = (EditText) findViewById(R.id.editBrfDesc);
        final EditText eDesc = (EditText) findViewById(R.id.editDesc);
        eTitle.setHint(title);
        eBrfD.setHint(brfD);
        eDesc.setHint(desc);

        Button btn_accept = (Button) findViewById(R.id.btn_edit_accept);
        final Button btn_cancel = (Button) findViewById(R.id.btn_edit_cancel);

        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!eTitle.getText().toString().isEmpty()) {
                    nTitle = eTitle.getText().toString();
                }
                else{
                    nTitle=title;
                }
                if(!eBrfD.getText().toString().isEmpty()) {
                    nBrfD = eBrfD.getText().toString();
                }
                else{
                    nBrfD=brfD;
                }
                if(!eDesc.getText().toString().isEmpty()) {
                    nDesc = eDesc.getText().toString();
                }
                else{
                    nDesc=desc;
                }
                thetasks.remove(position);
                task.setTitle(nTitle);
                task.setBriefDescription(nBrfD);
                task.setDescription(nDesc);
                thetasks.add(position, task);
                Writefiles.action(TaskEdit.this, thetasks);
                Intent i=new Intent(TaskEdit.this,TaskDetails.class);
                i.putExtra("task",task);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TaskEdit.this,TaskDetails.class);
                i.putExtra("task",task);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }
}
