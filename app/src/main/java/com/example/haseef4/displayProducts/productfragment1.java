package com.example.haseef4.displayProducts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.haseef4.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class productfragment1 extends Fragment {

    ListView productList;
    DatabaseReference DPref;
    ArrayList<productModel> dairyPlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.productfragment1_layout,container,false);
        View view = inflater.inflate(R.layout.productfragment1_layout,container,false);
        productList = (ListView) view.findViewById(R.id.dairy_products_view);
        dairyPlist = new ArrayList<>();

        DPref = FirebaseDatabase.getInstance().getReference().child("products").child("dairyProducts");
        DPref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot productSnapshot: snapshot.getChildren()){
                    productModel P = productSnapshot.getValue(productModel.class);
                    dairyPlist.add(P);
                }
                product_adapter adapter = new product_adapter(getContext(), dairyPlist);
                productList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}





