package com.example.kpadmin.tasklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by KP Admin on 9/24/2016.
 */

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "Table_TaskList";
    private static final String COLUMN_TITLE = "task_title";
    private static final String COLUMN_DESCRIPTION = "task_description";
    private static final String COLUMN_ID = "task_id";

    private static final String CREATE_TABLE = " CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY, "+COLUMN_TITLE+" TEXT , "+COLUMN_DESCRIPTION+" TEXT "+");";


    public Database(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTs "+ TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Task> getTasks(){

        ArrayList<Task> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        Cursor c = db.rawQuery(selectQuery, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            Task temp = new Task(c.getString(c.getColumnIndex(COLUMN_TITLE)),c.getString(c.getColumnIndex(COLUMN_DESCRIPTION)));
            temp.setID(c.getInt(c.getColumnIndex(COLUMN_ID)));
            list.add(temp);

            c.moveToNext();
        }

        return list;
    }

    public void addTask(Task task){


        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(COLUMN_TITLE,task.getTitle() );
        value.put(COLUMN_DESCRIPTION,task.getDescription());
        value.put(COLUMN_ID, (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME));
        db.insert(TABLE_NAME, null, value);
        db.close();
    }

    public void deleteTask(Task task){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID + " = "+ task.getID());
        db.close();
    }




}
