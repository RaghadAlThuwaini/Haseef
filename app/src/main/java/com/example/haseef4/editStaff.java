package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class editStaff extends AppCompatActivity {
    String name, ID, location, workingSince, age;
    TextInputEditText nameIn, IDIn ,locationIn, workingSinceIn, ageIn;
    DatabaseReference SRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SRef = FirebaseDatabase.getInstance().getReference();
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

        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void update(View view){
        String staffName, age, location, working_since;
        staffName = nameIn.getText().toString();
//        staffID = IDIn.getText().toString();
        age = ageIn.getText().toString();
        location = locationIn.getText().toString();
        working_since = workingSinceIn.getText().toString();
        staffModel s = new staffModel(staffName,age,location,working_since);
        s.setStaffID(ID);
        SRef.child("staff").child(ID).setValue(s);
    }
}