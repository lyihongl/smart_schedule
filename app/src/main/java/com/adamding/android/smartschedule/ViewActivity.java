package com.adamding.android.smartschedule;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adamding.android.smartschedule.database.DataManager;

import org.w3c.dom.Text;

public class ViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Button back;

        back = (Button)findViewById(R.id.backButton);
        TextView cal = (TextView)findViewById(R.id.calendar);
        if(DataManager.dbH!=null) {
            cal.setText(DataManager.dbH.getAllEvents().toString());
//            if(DataManager.dbH.getEvent(1)!=null)
//            DataManager.dbH.deleteEvent(DataManager.dbH.getEvent(1));
        }

        DataManager.dbH.deleteTable();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
