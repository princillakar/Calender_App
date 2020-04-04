package com.application.calender_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public Button add_event;
    public CalendarView calendarView1;
    public TextView view_date;
    private Context mContext;
    public int current_year;
    public int current_month;
    public int current_day;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_event = findViewById(R.id.add_event);

      //  mContext = this;
        CalendarView calendarView1 = (CalendarView) findViewById(R.id.calendarView);
        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                current_year = year;
                current_month = month;
                current_day= dayOfMonth;
                view_date = findViewById(R.id.view_date);

                String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                view_date.setText(Date);

                add_event.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intentToAddEvent = new Intent(MainActivity.this, event_add.class);
                        intentToAddEvent.putExtra("year", current_year);
                        intentToAddEvent.putExtra("month", current_month);
                        intentToAddEvent.putExtra("dayOfMonth", current_day);

                        startActivity(intentToAddEvent);
                       openAddButton();
                    }
                });
            }
        });
    }
  public void openAddButton() {
       Intent intent = new Intent(this, event_add.class);
      startActivity(intent);
   }
}






