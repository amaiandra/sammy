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
 * Created by macbook on 10/27/14.
 */
public class TaskDetails extends Activity implements View.OnClickListener {

    Button btn_delete;

   protected void onCreate (Bundle savedInstantState){
       super.onCreate (savedInstantState);
       setContentView(R.layout.activity_task_detail);

   }


    @Override
    public void onClick(View v) {

    }
}