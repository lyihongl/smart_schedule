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

    private Button addEv, viewCal, recieve, send;
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
        send = (Button) findViewById(R.id.send);
        recieve = (Button) findViewById(R.id.recieve);
        
        final Intent startMenu = new Intent(this, MenuActivity.class);
        addEv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startMenu);

            }
        });
        final Intent calView = new Intent(this, ViewActivity.class);
        final Intent startClient = new Intent(this, StartClient.class);
        final Intent startServer = new Intent(this, StartServer.class);
//        final Intent sync[] = {startServer, startClient};
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startClient);
            }
        });
        recieve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(startServer);
            }
        });
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
