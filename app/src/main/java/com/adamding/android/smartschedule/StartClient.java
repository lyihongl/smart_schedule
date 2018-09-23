package com.adamding.android.smartschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adamding.android.smartschedule.database.Client;
import com.adamding.android.smartschedule.database.Server;

import java.io.IOException;

public class StartClient extends AppCompatActivity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Client cl = new Client();
        try {
            cl.cli_main(5555, "127.0.0.1");
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();
    }

}
