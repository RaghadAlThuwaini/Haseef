package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.haseef4.displayProducts.product;
//import com.example.haseef4.displayProducts.product_Staff;
import com.example.haseef4.displayProducts.product_Staff;
import com.example.haseef4.displayRestock.restock;

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
        ImageView setting = findViewById(R.id.setting);
        ImageView notifications = findViewById(R.id.notifications);

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNotification();
            }
        });

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

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSetting();
            }
        });

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

        public void goToproduct(){
            startActivity(new Intent(this, product_Staff.class));
        }

        public void goTorestock(){
            startActivity(new Intent(this, restock.class));
        }

        public void goTostatistic(){
        startActivity(new Intent(this, statistic.class));
    }

        public void goToSetting(){
        startActivity(new Intent(this, setting.class));
    }

        public void goToNotification(){
        startActivity(new Intent(this, notification.class));
    }

}

