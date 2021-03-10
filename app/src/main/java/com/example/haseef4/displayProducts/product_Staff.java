package com.example.haseef4.displayProducts;

import android.content.Intent;
import android.os.Bundle;

import com.example.haseef4.AdminHome;
import com.example.haseef4.Login;
import com.example.haseef4.R;
import com.example.haseef4.StaffHome;
import com.example.haseef4.addproducts;
import com.example.haseef4.displayRestock.restock;
import com.example.haseef4.notification;
import com.example.haseef4.statistic;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class product_Staff extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    String Usertype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__staff);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new productfragment1(), "Dairy products");
        viewPagerAdapter.addFragment(new productfragment2(), "Juices");
        viewPagerAdapter.addFragment(new productfragment3(), "Chocolate");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ImageView notifications = findViewById(R.id.notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNotification();
            }
        });

//        ImageView add_icons = findViewById(R.id.add_icons);
//        add_icons.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goToAddProduct();
//            }
//        });

        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void goToNotification(){
        startActivity(new Intent(this, notification.class));
    }
    public void goToAddProduct(){
        startActivity(new Intent(this, addproducts.class));
    }
}