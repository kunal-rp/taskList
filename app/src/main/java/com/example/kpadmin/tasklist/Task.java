package com.example.kpadmin.tasklist;

/**
 * Created by KP Admin on 9/24/2016.
 */

public class Task {

    private String Title;
    private String Description;
    private int id;

    public Task(String Title, String Description){
        this.Title = Title;
        this.Description = Description;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }

    public String getTitle(){
        return Title;
    }

    public String getDescription(){
        return Description;
    }

}
