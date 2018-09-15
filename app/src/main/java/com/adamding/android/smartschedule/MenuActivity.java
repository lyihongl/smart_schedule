package com.adamding.android.smartschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final String date[] = new String[1];
        Button submit = findViewById(R.id.submit);
        final EditText dateField = findViewById(R.id.edit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date[0] = dateField.getText().toString();
                System.out.println(date[0]);
            }

        });



    }
}
