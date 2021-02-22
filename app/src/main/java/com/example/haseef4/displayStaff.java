package com.example.haseef4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
//dddd
public class displayStaff extends AppCompatActivity {
    ListView staffList;
    DatabaseReference SPref;
    ArrayList<staffModel> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_staff);

        staffList = (ListView) findViewById(R.id.staffList_view);
        List = new ArrayList<>();
//        List.add(new staffModel(
//                "20", "\"https://firebasestorage.googleapis.com/v0/b/haseef-34e27.appspot.com/o/receptionist.png?alt=media&token=7ca39d28-06b0-4c2a-b432-0e96a6c4fa5a\""
//                , "choco line","000", "saud", "2019"));
//        staff_adapter adapter = new staff_adapter(getBaseContext(), List);
//        staffList.setAdapter(adapter);

        SPref = FirebaseDatabase.getInstance().getReference().child("staff");
        SPref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
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
    }
}
