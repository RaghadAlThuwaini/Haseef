package com.example.haseef4;

import android.content.Intent;
import android.os.Bundle;

import com.example.haseef4.R;
import com.example.haseef4.StaffHome;
import com.example.haseef4.displayProducts.ViewPagerAdapter;
import com.example.haseef4.displayProducts.product;
import com.example.haseef4.displayProducts.productfragment1;
import com.example.haseef4.displayProducts.productfragment2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//import com.example.haseef4.ui.main.SectionsPagerAdapter;

public class restock extends AppCompatActivity {
////
////    ViewPager viewPager;
////    TabLayout tabLayout;
////    ViewPagerAdapter viewPagerAdapter;
////
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
//        ImageView back_icons = findViewById(R.id.back);
//
//
//        back_icons.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(restock.this,StaffHome.class));
//            }
//        });
//    }
//
//
//}
//
//
////        tabLayout = (TabLayout) findViewById(R.id.tabs2);
////        viewPager = (ViewPager) findViewById(R.id.view_pager2);
////        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
////        viewPagerAdapter.addFragment(new productfragment1(), "Dairy products");
////        viewPagerAdapter.addFragment(new productfragment2(), "Juices");
////        viewPager.setAdapter(viewPagerAdapter);
////        tabLayout.setupWithViewPager(viewPager);
////
////        ImageView back_icons = findViewById(R.id.back);
////        back_icons.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                startActivity(new Intent(restock.this, StaffHome.class));
////            }
////        })
////    }
////
////
    }}
