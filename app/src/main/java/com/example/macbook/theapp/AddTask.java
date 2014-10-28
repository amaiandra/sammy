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
 * Created by macbook on 10/23/14.
 */
public class AddTask extends Activity implements View.OnClickListener {

    EditText Title, Description;
    Button btn_add_accept, btn_add_cancel;
    Task tsk;




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



                thetasks = Readfiles.action(this);

                tsk.setTitle(ti);
                tsk.setBriefDescription(dc);
                tsk.setStatus(0);
                tsk.setDescription("Please edit the Description");
                thetasks.add(tsk);



                Writefiles.action(this, thetasks);

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

