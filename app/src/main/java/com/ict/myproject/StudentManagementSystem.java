package com.ict.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentManagementSystem extends AppCompatActivity {
    EditText name,roll_no,add,branch,email;
    Button reg,show;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    Student s;
    int max=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management_system);
        name=findViewById(R.id.name);
        roll_no=findViewById(R.id.roll_number);
        add=findViewById(R.id.address);
        branch=findViewById(R.id.branch);
        email=findViewById(R.id.email);
        reg=findViewById(R.id.register);
        show=findViewById(R.id.showdata);
        s=new Student();
        dbr=fd.getInstance().getReference().child("Student");
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                max=(int)snapshot.getChildrenCount();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=new Student();
                s.setName(name.getText().toString());
                s.setAddress(add.getText().toString());
                s.setEmail(email.getText().toString());
                s.setBranch(branch.getText().toString());
                s.setRoll_number(roll_no.getText().toString());
                dbr.child(String.valueOf(max+1)).setValue(s);
                reset();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentManagementSystem.this,ShowData.class);
                startActivity(intent);
            }
        });
    }
    void reset()
    {
        name.setText("");
        add.setText("");
        roll_no.setText("");
        email.setText("");
        branch.setText("");
    }
}