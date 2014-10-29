package com.example.macbook.theapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by macbook on 10/28/14.
 */
public class Writefiles {


    public static void action(Context context, List<Task> thetasks){
        try {
            FileOutputStream fos = context.openFileOutput(ListTasks.TASKS_CACHE_FILE, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(thetasks);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
