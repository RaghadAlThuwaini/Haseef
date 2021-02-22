package com.example.haseef4.displayRestock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.haseef4.R;
import com.example.haseef4.displayProducts.productModel;
import com.example.haseef4.displayProducts.product_adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class restockfragment3 extends Fragment {
    ListView productList;
    DatabaseReference JPref;
    ArrayList<productModel> chocolatePlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restockfragment3_layout, container, false);
        productList = (ListView) view.findViewById(R.id.chocolate_restock_view);
        chocolatePlist = new ArrayList<>();

        JPref = FirebaseDatabase.getInstance().getReference().child("products").child("Chocolate");//
        Query getRestockProducts = JPref.orderByChild("restock").endAt(5);
        getRestockProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot productSnapshot : snapshot.getChildren()) {
                    productModel P = productSnapshot.getValue(productModel.class);
                    chocolatePlist.add(P);
                }
                product_adapter adapter = new product_adapter(getContext(), chocolatePlist);
                productList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}
