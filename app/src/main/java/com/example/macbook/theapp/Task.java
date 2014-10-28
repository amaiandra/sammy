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

<<<<<<< HEAD
    public void setStatus(int Status) {
        this.Status = Status;
    }


=======
        return Description;
    }
    public void setStatus (int Status){
        this.Status = Status;
    }
    public void setBriefDescription(String BriefDescription) {
        this.BriefDescription = BriefDescription;
    }
>>>>>>> 28e54355dd8c01019bd9e46b9a54cb9154330469
    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}




