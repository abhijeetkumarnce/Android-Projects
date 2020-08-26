package com.ict.myproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowData extends AppCompatActivity {
    RecyclerView rcv;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        rcv=findViewById(R.id.rec);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        fd=FirebaseDatabase.getInstance();
        dbr=fd.getReference("Student");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Student,DataHolder> fra=new FirebaseRecyclerAdapter<Student, DataHolder>
                (Student.class,
                        R.layout.my_custom_design,
                        DataHolder.class,
                        dbr) {
            @Override
            protected void populateViewHolder(DataHolder dataHolder, Student student, int i) {
                dataHolder.setView(getApplicationContext(),student.getName(),student.getRoll_number(),
                        student.getAddress(),student.getEmail(),student.getBranch());
            }
        };
        rcv.setAdapter(fra);
    }
}