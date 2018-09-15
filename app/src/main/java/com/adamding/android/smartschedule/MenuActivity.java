package com.adamding.android.smartschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    //ArrayList<String> input = new ArrayList<String>();
    EditText eventIn, dateIn, timeIn;

    Button subButton, backButton;

    //TextView subText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //initializing variables
        subButton =(Button) findViewById(R.id.subButton);
        backButton = (Button) findViewById(R.id.addButton);
        //subText = (TextView) findViewById(R.id.subText);
        eventIn = (EditText) findViewById(R.id.editTextEvent);
        dateIn = (EditText) findViewById(R.id.editTextDate);
        timeIn = (EditText) findViewById(R.id.editTextTime);

        //
        subButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               // subText.setText("Submitted! Go on with your day");

                //storing user input into variables
                String event = eventIn.getText().toString();
                int date = Integer.valueOf(dateIn.getText().toString());
                int time = Integer.valueOf(timeIn.getText().toString());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

//    public void switchToev(View view){
//        Intent startEventAct = new Intent (this, MainActivity.class);
//        startActivity(startEventAct);
//    }
}
