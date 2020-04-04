package com.application.calender_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_v_a extends RecyclerView.Adapter<recycler_v_a.ViewHolder>{

    Context mContext;
    private ArrayList<String> theList = new ArrayList<>();

    public recycler_v_a(Context mContext, ArrayList<String> theList) {
        this.mContext = mContext;
        this.theList = theList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eventTextView.setText(theList.get(position));
    }

    @Override
    public int getItemCount() {
        return theList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView eventTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTextView = itemView.findViewById(R.id.eventTextView);
        }
    }
}
