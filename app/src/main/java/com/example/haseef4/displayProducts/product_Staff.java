package com.example.haseef4.displayProducts;

import android.content.Intent;
import android.os.Bundle;

import com.example.haseef4.R;
import com.example.haseef4.addproducts;
import com.example.haseef4.notification;
import com.example.haseef4.setting;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

public class product_Staff extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    String Usertype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__staff);
        ImageView setting = findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSetting();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabs2);
        viewPager = (ViewPager) findViewById(R.id.view_pager2);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new productfragmentStaff1(), "Dairy products");
        viewPagerAdapter.addFragment(new productfragmentStaff2(), "Juices");
        viewPagerAdapter.addFragment(new productfragmentStaff3(), "Chocolate");
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
    public void goToSetting(){
        startActivity(new Intent(this, setting.class));
    }
    public void goToNotification(){
        startActivity(new Intent(this, notification.class));
    }
    public void goToAddProduct(){
        startActivity(new Intent(this, addproducts.class));
    }
}