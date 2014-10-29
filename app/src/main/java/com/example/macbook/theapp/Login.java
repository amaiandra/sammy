package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Login extends Activity {
    EditText username, password;
    Button btn_login, btn_signup;
    User user;



    public static final String USER_CACHE_FILE = "user_cache.ser";
    public List<User> theusers = new ArrayList<User>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.liusername);
        password=(EditText) findViewById(R.id.lipassword);
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringusername= username.getText().toString();
                String stringpassword= password.getText().toString();
                user = new User();
                user.setUsername(stringusername);
                user.setPassword(stringpassword);
                theusers = ReadUsers.action(Login.this);
                int position =0;


                Log.d(Login.class.getSimpleName(), "user.getUsername()=" + user.getUsername() +
                        ", theusers=" + theusers);
                for (int a=0; a<theusers.size(); a++){
                    if (user.getUsername().equals(theusers.get(a).getUsername())) {
                     position=a;
                        if(user.getPassword().equals(theusers.get(position).getPassword())){
                            Intent f = new Intent(Login.this, ListTasks.class);
                            f.putExtra("username", stringusername);
                            startActivity(f);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "The passwprd and username dont match", Toast.LENGTH_SHORT);
                        }


                    }
                }







            }

        });


        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);

            }
        });

        //typeface for app name login page
        TextView loginpage_appname  = (TextView)findViewById(R.id.appname);
        Typeface headings = Typeface.createFromAsset(getAssets(),"fonts/SF_Arch_Rival_Bold.ttf");
        loginpage_appname.setTypeface(headings);

        //typeface for tagline login page
        TextView loginpage_tagline  = (TextView)findViewById(R.id.taglne);
        Typeface paragraph = Typeface.createFromAsset(getAssets(),"fonts/CaviarDreams.ttf");
        loginpage_tagline.setTypeface(paragraph);

        //typeface for buttons
        TextView login_button  = (TextView)findViewById(R.id.btn_login);
        login_button.setTypeface(paragraph);




    }




}
