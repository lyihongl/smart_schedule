package com.adamding.android.smartschedule;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.adamding.android.smartschedule.database.Event;
import com.adamding.android.smartschedule.database.dbHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addEv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        dbHelper db = new dbHelper(this);
//
////        db.addBook(new Book("Animal Farm", "George Orwell"));
//        db.addEvent(new Event(1, "June 15", "1 PM", "Birthday"));
//
//        Log.d("first event", db.getEvent(1).toString());

        addEv = (Button) findViewById(R.id.addEv);

        final Intent startMenu = new Intent(this, MenuActivity.class);
        addEv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startMenu);

            }
        });




    }
//    private void launchActivity(){
//        final Intent startMenu = new Intent(this, MenuActivity.class);
//        startActivity(startMenu);
//    }
}
