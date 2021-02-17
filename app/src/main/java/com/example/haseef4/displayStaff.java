package com.example.haseef4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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
        //return inflater.inflate(R.layout.productfragment1_layout,container,false);
//        View view = inflater.inflate(R.layout.activity_display_staff,container,false);
        staffList = (ListView) findViewById(R.id.staffList_view);
        List = new ArrayList<>();

        SPref = FirebaseDatabase.getInstance().getReference().child("staff");
        SPref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot productSnapshot: snapshot.getChildren()){
                    staffModel s = productSnapshot.getValue(staffModel.class);
                    List.add(s);
                }
                staff_adapter adapter = new staff_adapter(getBaseContext(), List);
                staffList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
