package com.example.haseef4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class editStaff extends AppCompatActivity {
    String name, ID, location, workingSince, age,image;
    TextInputEditText nameIn, IDIn ,locationIn, workingSinceIn, ageIn;
    DatabaseReference SRef;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView setting = findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSetting();
            }
        });
        SRef = FirebaseDatabase.getInstance().getReference();
        //get from previous intent
        setContentView(R.layout.activity_edit_staff);
        name = getIntent().getExtras().getString("name");
        ID = getIntent().getExtras().getString("ID");
        age = getIntent().getExtras().getString("age");
        location = getIntent().getExtras().getString("location");
        workingSince = getIntent().getExtras().getString("workingSince");
        image = getIntent().getExtras().getString("Image");

        //catch txt input from editStaff.xml
        nameIn = findViewById(R.id.staffNameEdit);
        IDIn = findViewById(R.id.staffIDEdit);
        locationIn = findViewById(R.id.locationEdit);
        workingSinceIn = findViewById(R.id.workingEdit);
        ageIn =  findViewById(R.id.staffAgeEdit);
        imageView = findViewById(R.id.staffImage2);
        Picasso.get().load(image).into(imageView);
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
        staffModel s = new staffModel(staffName,age,location,working_since, image);
        s.setStaffID(ID);
        SRef.child("staff").child(ID).setValue(s).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(editStaff.this, "Staff updated", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(editStaff.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


}
    public void goToSetting(){
        startActivity(new Intent(this, setting.class));
    }

    }
