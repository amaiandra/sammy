package com.example.macbook.theapp;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    private final ListTasks listTasksActivity;
    private LayoutInflater inflater;
    private List<Task> tasks;

    public TaskAdapter(ListTasks activity, List<Task> aa) {
        super(activity, R.layout.row_task, aa);
        tasks = aa;
        inflater = activity.getWindow().getLayoutInflater();
        this.listTasksActivity = activity;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View theView = inflater.inflate(R.layout.row_task, parent, false);
        TextView title = (TextView) theView.findViewById(R.id.Title);
        title.setText(tasks.get(position).getTitle());
        TextView description = (TextView) theView.findViewById(R.id.Description);
        description.setText(tasks.get(position).getDescription());
        ImageView imgbutton = (ImageView) theView.findViewById(R.id.imageButton);
        if(tasks.get(position).getStatus()==1){
            imgbutton.setImageResource(R.drawable.done);
        }
        else {
            imgbutton.setImageResource(R.drawable.notdone);
        }
        final TaskAdapter theAdapter = this;
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.get(position).setStatus((tasks.get(position).getStatus()+1)%2);
                Writefiles.action(getContext(), tasks);

                theAdapter.notifyDataSetChanged();

            }
        });
        return theView;
    }
}


