package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addStaff extends AppCompatActivity {

    EditText staffname;
    EditText staffid;
    EditText workingsince;
    EditText Sage;
    EditText slocation;
    Button insertstaff, addStaff;
    ImageView image;
    DatabaseReference staffDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        staffname = findViewById(R.id.staffnametext);
        staffid = findViewById(R.id.staffidtext);
        workingsince = findViewById(R.id.workingsincetext);
        Sage = findViewById(R.id.agetext);
        slocation = findViewById(R.id.locationtext);
        insertstaff = findViewById(R.id.insertstaff);
        image = findViewById(R.id.imageView2);
        addStaff = findViewById(R.id.addStaff);
        staffDB = FirebaseDatabase.getInstance().getReference().child("staff");


        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        insertstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStaffData();
            }
        });

    }

    public void insertStaffData(){
        String age=staffname.getText().toString();
        String location=slocation.getText().toString();
        String staffName=staffname.getText().toString();
        String working_since=workingsince.getText().toString();
        String staffID=staffid.getText().toString();
        staffModel s=new staffModel(age,location,staffID,staffName,working_since);
        staffDB.push().setValue(s);
        Toast.makeText(addStaff.this,"Staff Added",Toast.LENGTH_SHORT).show();
    }
}


