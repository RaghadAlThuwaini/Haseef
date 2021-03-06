package com.example.haseef4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.haseef4.displayProducts.productModel;
import com.example.haseef4.displayProducts.product_adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class displayStaff extends AppCompatActivity {
    ListView staffList;
    DatabaseReference SPref;
    ArrayList<staffModel> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_staff);
        ImageView setting = findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSetting();
            }
        });
        staffList = (ListView) findViewById(R.id.staffList_view);
        List = new ArrayList<>();

        SPref = FirebaseDatabase.getInstance().getReference().child("staff");


        SPref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List.clear();
                for(DataSnapshot staffSnapshot: snapshot.getChildren()){
                    staffModel s = staffSnapshot.getValue(staffModel.class);
                    List.add(s);
                }
                staff_adapter adapter = new staff_adapter(getBaseContext(), List);
                staffList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

//        staffList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                final int item = position;
//                new AlertDialog.Builder(displayStaff.this)
//                        .setIcon(R.drawable.ic_launcher_delete_foreground)
//                        .set
//                return false;
//            }
//        });

        Button addstaff=findViewById(R.id.addStaff);
        addstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              goToAddStaff();
            }
        });
        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        ImageView notifications = findViewById(R.id.notifications);
//        notifications.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goToNotification();
//            }
//        });
//
    }
    public void goToAddStaff(){
        Intent intent = new Intent(this, addStaff.class);
        startActivity(intent);
    }
    public void goToSetting(){
        startActivity(new Intent(this, setting.class));
    }
//    public void goToNotification(){
//        startActivity(new Intent(this, notification.class));
//    }

}
