package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Login extends Activity implements OnClickListener {
    EditText etUser, etPass;
    Button btn_login, btn_signup;



    public static final String USER_CACHE_FILE = "user_cache.ser";
    public List<User> theusers = new ArrayList<User>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser=(EditText) findViewById(R.id.etUser);
        etPass=(EditText) findViewById(R.id.etPass);
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_signup = (Button) findViewById(R.id.btn_signout);
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
    public void onClick (View v){

        String na=etUser.getText().toString();
        String pa=etPass.getText().toString();




        switch (v.getId()){

            case R.id.btn_login:


                theusers = ReadUsers.action(this);
                int position = 0;

                for (int a=0; a < theusers.size(); a++){
                    if ( theusers.get(a).getUsername()==na){
                        position = a;
                    }
                }





                if(na.equals(theusers.get(position).getUsername())&&pa.equals(theusers.get(position).getPassword())){



                    Intent f=new Intent(this,ListTasks.class);
                    f.putExtra("username", na);
                    startActivity(f);

                }
                else{
                    Toast.makeText( getApplicationContext(), "The username and/or password is incorrect", Toast.LENGTH_SHORT).show();
                }
                

                break;




        }

    }


}
