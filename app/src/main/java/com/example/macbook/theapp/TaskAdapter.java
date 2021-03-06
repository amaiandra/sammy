package com.example.macbook.theapp;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView briefdescription = (TextView) theView.findViewById(R.id.BriefDescription);
        briefdescription.setText(tasks.get(position).getBriefDescription());
        ImageView imgbutton = (ImageView) theView.findViewById(R.id.imageButton);
        if(tasks.get(position).getStatus()==1){
            imgbutton.setImageResource(R.drawable.radiobtn_on);
        }
        else {
            imgbutton.setImageResource(R.drawable.radiobtn_off);
        }
        final TaskAdapter theAdapter = this;
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.get(position).setStatus((tasks.get(position).getStatus()+1)%2);
                Writefiles.action(getContext(), tasks);
                if(tasks.get(position).getStatus()%2 ==1){
                    ClassicSingleton.getInstance().playSound(theAdapter.getContext());
                }

                theAdapter.notifyDataSetChanged();

            }
        });
        return theView;
    }
}


