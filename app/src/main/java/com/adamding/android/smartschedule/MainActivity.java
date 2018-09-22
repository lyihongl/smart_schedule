package com.adamding.android.smartschedule;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.adamding.android.smartschedule.database.DataManager;
import com.adamding.android.smartschedule.database.Event;
import com.adamding.android.smartschedule.database.dbHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addEv, viewCal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       0
        final dbHelper db = new dbHelper(this);
//        db.deleteTable();
        DataManager.init(this.getApplicationContext(), db);
        DataManager.save();
        addEv = (Button) findViewById(R.id.addEv);
        viewCal = (Button) findViewById(R.id.viewCal);

        final Intent startMenu = new Intent(this, MenuActivity.class);
        addEv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startMenu);

            }
        });
        final Intent calView = new Intent(this, ViewActivity.class);
        viewCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(calView);
            }
        });

    }
//    private void launchActivity(){
//        final Intent startMenu = new Intent(this, MenuActivity.class);
//        startActivity(startMenu);
//    }
}
