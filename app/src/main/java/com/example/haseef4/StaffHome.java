package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StaffHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
        ImageView statistic = findViewById(R.id.statistic);
        ImageView statistic_icons = findViewById(R.id.statistic_icons);
        ImageView product = findViewById(R.id.product);
        ImageView product_icons = findViewById(R.id.product_icons);
        ImageView restock = findViewById(R.id.restock);
        ImageView restock_icons = findViewById(R.id.restock_icons);

//        statistic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goTostatistic();
//            }
//        });
//        statistic_icons.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goTostatistic();
//            }
//        });
//    }
//    private void goTostatistic(){
//        Intent intent = new Intent(this, statistic.class);
//        startActivity(intent);
//    }

        product.setOnClickListener(new View.OnClickListener() {
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

        restock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTorestock();
            }
        });

        restock_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTorestock();
            }
        });
    }


        private void goToproduct(){
     Intent intent = new Intent(this, product.class);
          startActivity(intent);
         }

    private void goTorestock(){
        Intent intent = new Intent(this, restock.class);
        startActivity(intent);
    }
    }

