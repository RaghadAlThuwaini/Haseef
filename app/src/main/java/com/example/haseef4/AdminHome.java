package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import com.example.haseef4.displayProducts.product;

import com.example.haseef4.displayProducts.product;


public class AdminHome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_staff);

        ImageView statistic=findViewById(R.id.statisticIconsAdmin);
        ImageView statistic_icons=findViewById(R.id.statisticAdmin);
        ImageView products = findViewById(R.id.productAdmin);
        ImageView product_icons = findViewById(R.id.productIconsAdmin);

        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTostatistic();
            }
        });
        statistic_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTostatistic();
            }
        });
        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToproduct();
            }
        });

        product_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToproduct();
            }
        });
    }
    public void goTostatistic(){
        Intent intent = new Intent(this, statistic.class);
        startActivity(intent);
    }
    public void goToproduct(){
        startActivity(new Intent(this, product.class));
    }

    }
