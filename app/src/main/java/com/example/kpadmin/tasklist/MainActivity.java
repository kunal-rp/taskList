package com.example.kpadmin.tasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView list;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasklist_main);
        database = new Database(this);

        list = (ListView) findViewById(R.id.taskList);
        ArrayList<Task> tasks = database.getTasks();
        adapter = new ListAdapter(this, tasks);
        list.setAdapter(adapter);
        ((BaseAdapter) list.getAdapter()).notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ((BaseAdapter) list.getAdapter()).notifyDataSetChanged();
    }

    public void addTask(View view){
        Intent intent = new Intent(getApplicationContext(), CreateTask.class);
        startActivity(intent);

    }


}
