package com.application.calender_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class event_add extends AppCompatActivity {

    private int year;
    private Button button_add;
    public Button button_view;
    public EditText editText;
    public S_Q_L d_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);
        year = getIntent().getIntExtra("year", -1);
//--------------------------------------------------------------------------------------------------
        editText = (EditText) findViewById(R.id.editText);
        button_add = (Button) findViewById(R.id.button_add);
        button_view = (Button) findViewById(R.id.button_view);
        d_base = new S_Q_L(this);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!= 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(event_add.this, " Write something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });
//.............................................................................................................
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentI = new Intent(event_add.this, All_events.class);

                startActivity(intentI);
                OpenViewButton();
            }
        });
    }
    public void AddData(String newEntry) {

        boolean insertData = d_base.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Event successfully added!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
    public void OpenViewButton() {
        Intent intent1 = new Intent(this, All_events.class);
        startActivity(intent1);
    }

}
