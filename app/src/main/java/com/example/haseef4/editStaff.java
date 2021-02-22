package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class editStaff extends AppCompatActivity {
    String name, ID, location, workingSince, age;
    TextInputEditText nameIn, IDIn ,locationIn, workingSinceIn, ageIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
        //get from previous intent
        setContentView(R.layout.activity_edit_staff);
        name = getIntent().getExtras().getString("name");
        ID = getIntent().getExtras().getString("ID");
        age = getIntent().getExtras().getString("age");
        location = getIntent().getExtras().getString("location");
        workingSince = getIntent().getExtras().getString("workingSince");

        //catch txt input from editStaff.xml
        nameIn = findViewById(R.id.staffNameEdit);
        IDIn = findViewById(R.id.staffIDEdit);
        locationIn = findViewById(R.id.locationEdit);
        workingSinceIn = findViewById(R.id.workingEdit);
        ageIn =  findViewById(R.id.staffAgeEdit);
        // set txt input of editStaff.xml to the previous intent's values
        nameIn.setText(name);
        IDIn.setText(ID);
        locationIn.setText(location);
        workingSinceIn.setText(workingSince);
        ageIn.setText(age);

    }
}