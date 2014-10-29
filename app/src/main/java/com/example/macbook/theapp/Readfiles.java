package com.example.macbook.theapp;

import android.app.Application;
import android.content.Context;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Created by macbook on 10/28/14.
 */
public class Readfiles {


    public static List action(Context context, String TASKS_CACHE_FILE) {
        List<Task> thetasks = new ArrayList<Task>();
        try {

            FileInputStream fis = context.openFileInput(TASKS_CACHE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            thetasks = (List<Task>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thetasks;
    }
}


