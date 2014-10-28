package com.example.macbook.theapp;

import android.graphics.Typeface;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by macbook on 10/23/14.
 */
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Title;
    private String BriefDescription;
    private int Status;
    private String Description;

    public Task() {}

    public String getTitle() {
        return Title;
    }
    public String getBriefDescription() {

        return BriefDescription;
    }
    public void setTitle(String Title) {

        this.Title = Title;

    }
    public int getStatus() {
        return Status;
    }
    public String getDescription() {





        return Description;
    }
    public void setStatus (int Status){
        this.Status = Status;
    }
    public void setBriefDescription(String BriefDescription) {
        this.BriefDescription = BriefDescription;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}




