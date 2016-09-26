package com.example.kpadmin.tasklist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KP Admin on 9/24/2016.
 */

public class ListAdapter extends ArrayAdapter<Task> {

    public ListAdapter(Context context, ArrayList<Task> tasks){
        super(context, R.layout.object_task_detail, tasks);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.object_task_detail, parent, false);

        Task task = getItem(position);

        TextView Title = (TextView) customView.findViewById(R.id.Title);
        TextView Description = (TextView) customView.findViewById(R.id.Description);

        Title.setText(task.getTitle());
        Description.setText(task.getDescription());

        return customView;
    }

}
