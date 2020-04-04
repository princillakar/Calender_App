package com.application.calender_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class All_events extends AppCompatActivity {

     S_Q_L d_base;
    private ArrayList<String> theList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events);
        RecyclerView recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        d_base = new S_Q_L(this);


        Cursor data = d_base.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(this, "OOPS! No events in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
               //@Override
                      // public recycler_view  extends RecyclerView.Adapter(){
                   //RecyclerView.Adapter rv =new ArrayAdapter<>(this ,android.R.layout.simple_list_item_1, theList);
                // ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
//RecyclerView.Adapter recycler_v_a= new Adapter(this ,android.R.layout.simple_list_item_1, theList);
//                recycler_view.setAdapter((RecyclerView.Adapter) recycler_v_a);


            }

            recycler_v_a adapter = new recycler_v_a(All_events.this, theList);
            recycler_view.setAdapter(adapter);
            recycler_view.setLayoutManager(new LinearLayoutManager(this));


        }
    }
}
