package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 10/23/14.
 */
public class Signup extends Activity implements View.OnClickListener {


    Button btn_user_accept, btn_user_cancel;
    User user;
    String urnm, pw, pw2;


    public List<User> theusers = new ArrayList<User>();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);



        btn_user_accept = (Button) findViewById(R.id.btn_user_accept);
        btn_user_cancel = (Button) findViewById(R.id.btn_user_cancel);
        btn_user_accept.setOnClickListener(this);
        btn_user_cancel.setOnClickListener(this);


    }

    public void onClick(View v) {
        EditText Username = (EditText) findViewById(R.id.username);
        EditText Password = (EditText) findViewById(R.id.password);
        EditText Password2 = (EditText) findViewById(R.id.password2);



        if (v == this.btn_user_accept) {
            user = new User();
            urnm = Username.getText().toString();
            pw = Password.getText().toString();
            pw2 = Password2.getText().toString();
            theusers = ReadUsers.action(this);

            if (!urnm.isEmpty() && !pw.isEmpty() && !pw2.isEmpty()) {

                user.setUsername(urnm);

                if (!pw.equals(pw2)) {
                    Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                }
                else
                {


                    user.setPassword(pw);

                    theusers.add(user);
                    Writeuser.action(this, theusers);

                    Intent i = new Intent(this, Login.class);
                    startActivity(i);


                }
            }
        }

        if (v == this.btn_user_cancel) {
        Intent i = new Intent(this, Login.class);
            startActivity(i);
            }


    }
}




