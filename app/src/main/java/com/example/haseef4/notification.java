package com.example.haseef4;
//
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.haseef4.displayProducts.productAdapterStaff;
import com.example.haseef4.displayProducts.productAdapterStaffArduino;
import com.example.haseef4.displayProducts.productModel;
import com.example.haseef4.displayProducts.productModelArduino;
import com.example.haseef4.displayProducts.product_adapter;
import com.example.haseef4.displayProducts.product_adapterArduino;

import java.util.ArrayList;


public class notification extends AppCompatActivity {
    ListView list,list2;
    public static ArrayList<productModel> toNotifyProducts = new ArrayList<>();
    public static ArrayList<productModelArduino> toNotifyProductsArduino = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        list = (ListView) findViewById(R.id.toNotify_listview);
        list2 = (ListView) findViewById(R.id.toNotify_listview2);
        productAdapterStaff adapter = new productAdapterStaff(getBaseContext(), toNotifyProducts);
        list.setAdapter(adapter);

        productAdapterStaffArduino adapter2 = new productAdapterStaffArduino(getBaseContext(), toNotifyProductsArduino);
        list2.setAdapter(adapter2);

        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}