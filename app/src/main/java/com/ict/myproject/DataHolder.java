package com.ict.myproject;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataHolder extends RecyclerView.ViewHolder {
    View view;
    public DataHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
    }

    public void setView(Context context,String name,String roll_no,
                        String add,String email,String branch) {
        TextView sname=view.findViewById(R.id.name);
        TextView semail=view.findViewById(R.id.email);
        TextView sroll=view.findViewById(R.id.roll_no);
        TextView sbranch=view.findViewById(R.id.branch);
        TextView sadd=view.findViewById(R.id.add);
        sname.setText(name);
        sroll.setText(roll_no);
        semail.setText(email);
        sadd.setText(add);
        sbranch.setText(branch);
    }
}
