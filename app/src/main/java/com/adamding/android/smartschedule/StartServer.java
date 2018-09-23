package com.adamding.android.smartschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adamding.android.smartschedule.database.Server;

import java.io.IOException;

public class StartServer extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Server s = new Server();
        try {
            s.svr_main(5555);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
