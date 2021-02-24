package com.example.haseef4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class setting extends AppCompatActivity {
   private TextView email1,id1,line1,signOut;
   private ImageView image1;
   private String email,password;
   //private static  final  String USER="users";
   private FirebaseDatabase database;
   private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

       // Intent intent= getIntent();
      // email= intent.getStringExtra("email");

        email1=findViewById(R.id.email_1);
        id1=findViewById(R.id.id_1);
        line1=findViewById(R.id.line_1);
        image1=findViewById(R.id.image_1);

        database=FirebaseDatabase.getInstance();
        mDatabase=database.getReference("users");
        signOut=findViewById(R.id.sign_out);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot ds : snapshot.getChildren()){
                    Users us = ds.getValue(Users.class);
                    if(us.getEmail().equals(LogedUser.email)){
                         id1.setText(us.getId());
                        line1.setText(us.getLine());
                        email1.setText(us.getEmail());
                        Picasso.get().load(us.getImage()).into(image1);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void signout(View v){
       Intent intent=new Intent(this,Login.class);
       startActivity(intent);
       finish();
    }


}