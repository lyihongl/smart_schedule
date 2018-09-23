package com.adamding.android.smartschedule.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class DataManager {

    public static dbHelper dbH;

    public static Context context;

    public DataManager(){

    }

    public static void init(Context c, dbHelper db){
        dbH = db;
        context = c;
    }

    public static void save(){

        File storage = context.getFilesDir();
//         = dbList.get(0);
        Log.d("db location", dbH.getWritableDatabase().getPath());

//       for(int i = 1; i<20; i++){
//           dbList.get(0).deleteEvent(dbList.get(0).getEvent(i));
//       }
//        dbList.get(0).deleteTable();
//        context.deleteDatabase("eventsDB.db");
//        Log.d("ALL ",""+dbList.get(0).getAllEvents());
    }
    public SQLiteDatabase getFile(){
        return dbH.getWritableDatabase();
    }

}
