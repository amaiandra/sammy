package com.example.macbook.theapp;

import android.content.Context;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 10/29/14.
 */
public class ReadUsers {

    public static List action(Context context) {
        List<User> theusers = new ArrayList<User>();
        try {

            FileInputStream fis = context.openFileInput(Login.USER_CACHE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            theusers = (List<User>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theusers;
    }
}
