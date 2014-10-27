package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Login extends Activity implements OnClickListener {
    EditText etUser, etPass;
    Button btn_login;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser=(EditText) findViewById(R.id.etUser);
        etPass=(EditText) findViewById(R.id.etPass);
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);




    }
    public void onClick (View v){

        String na=etUser.getText().toString();
        String pa=etPass.getText().toString();



        switch (v.getId()){

            case R.id.btn_login:

                ////if(na.equals("paul")&&pa.equals("1234")){



                    Intent i=new Intent(this,ListTasks.class);
                    startActivity(i);

                /////}
                

                break;




        }

    }


}
