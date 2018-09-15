package com.adamding.android.smartschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button addEv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
