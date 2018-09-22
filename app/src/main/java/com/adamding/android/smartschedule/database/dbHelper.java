package com.adamding.android.smartschedule.database;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLInput;
import java.util.LinkedList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "eventDB.db";

    //table name
    private static final String TABLE_NAME = "events";

    private static final String ID = "id";
    private static final String SECTION = "section";
    private static final String DATE = "date";
    private static final String TIME = "time";
    private static final String EVENT = "event";

    private static final String[] COLUMNS = {ID, SECTION, DATE, TIME, EVENT};

    public dbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        String CR_TBL = "CREATE TABLE events ( "+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "section INT, "+
                "date INT, "+
                "time INT, "+
                "event TEXT)";

        db.execSQL(CR_TBL);
        Log.d("DB", db.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS events");

        this.onCreate(db);
    }

    public void addEvent(Event e){
        Log.d("addEvent", e.toString());

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(SECTION, e.getSection());
        v.put(DATE, e.getDate());
        v.put(TIME, e.getTime());
        v.put(EVENT, e.getEvent());

        db.insert(TABLE_NAME, null, v);
//        Log.d("Path for DB", db.getPath());
//        DataManager.save();


        db.close();
    }

    public Event setUpBlankE(Cursor c){
        Event e = new Event();
        e.setID(Integer.parseInt(c.getString(0)));
        e.setSection(Integer.parseInt(c.getString(1)));
        e.setDate(Integer.parseInt(c.getString(2)));
        e.setTime(Integer.parseInt(c.getString(3)));
        e.setEvent(c.getString(4));
        return e;
    }
    public void createEventContent(Event e, ContentValues v){
        v.put(SECTION, e.getSection());
        v.put(DATE, e.getDate());
        v.put(TIME, e.getTime());
        v.put(EVENT, e.getEvent());

    }

    public Event getEvent(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_NAME, COLUMNS, " id=? ", new String[]{String.valueOf(id)}, null, null, null, null);
        if(c!=null){
            c.moveToFirst();
        }
        Event e = setUpBlankE(c);


        Log.d("getEvent ", e.toString());

        return e;
    }

    public List<Event> getAllEvents(){
        List<Event> events = new LinkedList<Event>();

        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        Event e = null;
        if(c.moveToFirst()){
            do{
                e = setUpBlankE(c);
                events.add(e);
            }while(c.moveToNext());
        }
        Log.d("get all events ", events.toString());
        return events;
    }

    public int updateEvent(Event e){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        createEventContent(e, values);
        int i = db.update(TABLE_NAME, values, ID+" = ?", new String[]{String.valueOf(e.getID())});
        db.close();
        return i;
    }

    public void deleteEvent(Event e){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, ID+" = ?", new String[] {String.valueOf(e.getID())});

        db.close();
        Log.d("deleteEvent", e.toString());
    }

    public void deleteTable(){
        Log.d("App started", "ewere");
        this.getWritableDatabase().execSQL("DROP TABLE IF EXISTS 'eventDB.events'");



        Log.d("Deleted Table", this.getWritableDatabase().getPath());
    }




}
