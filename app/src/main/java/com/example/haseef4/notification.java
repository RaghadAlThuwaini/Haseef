package com.example.haseef4;
//
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.haseef4.displayProducts.productModel;
import com.example.haseef4.displayProducts.product_adapter;

import java.util.ArrayList;


public class notification extends AppCompatActivity {
    ListView list;
    public static ArrayList<productModel> toNotifyProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        list = (ListView) findViewById(R.id.toNotify_listview);
        product_adapter adapter = new product_adapter(getBaseContext(), toNotifyProducts);
        list.setAdapter(adapter);

        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}