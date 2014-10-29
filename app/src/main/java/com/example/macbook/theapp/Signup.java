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

    EditText Username, Password, Password2;
    Button btn_user_accept, btn_user_cancel;
    User user;




    public List<User> theusers = new ArrayList<User>();




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Password2 = (EditText) findViewById(R.id.password2);

        btn_user_accept = (Button) findViewById(R.id.btn_user_accept);
        btn_user_cancel = (Button) findViewById(R.id.btn_user_cancel);
        btn_user_accept.setOnClickListener(this);
        btn_user_cancel.setOnClickListener(this);


    }

    public void onClick(View v) {
        user = new User();
        String urnm =Username.getText().toString();
        String pw = Password.getText().toString();
        String pw2 = Password2.getText().toString();

        if (v ==this.btn_user_accept) {
            if (!urnm.isEmpty() && !pw.isEmpty() &&!pw2.isEmpty()) {



                theusers = ReadUsers.action(this);


                user.setUsername(urnm);


                for (int a=0; a < theusers.size(); a++){
                    if ( theusers.get(a).getUsername()==user.getUsername()){
                        Toast.makeText(getApplicationContext(), "Username already exists",  Toast.LENGTH_SHORT).show();
                    }
                }



                if(pw==pw2){
                    user.setPassword(pw);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Passwords don't match",  Toast.LENGTH_SHORT).show();
                }
                theusers.add(user);



                Writeuser.action(this, theusers);

                Intent i = new Intent(this, Login.class);
                startActivity(i);
            }
        }
        if (v ==this.btn_user_cancel){
            Intent i=new Intent(this,Login.class);
            startActivity(i);
        }

    }


}

