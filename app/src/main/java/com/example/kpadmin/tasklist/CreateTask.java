package com.example.kpadmin.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by KP Admin on 9/24/2016.
 */

public class CreateTask extends AppCompatActivity {

    Database database;
    EditText Title;
    EditText Description;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtask);

        database = new Database(this);

        Title = (EditText)findViewById(R.id.Title);
        Description = (EditText)findViewById(R.id.Description);

    }

    public void saveTask(View view){
        Task task = new Task(Title.getText().toString(), Description.getText().toString());
        database.addTask(task);
        this.finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
}
