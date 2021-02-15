package com.example.haseef4.displayRestock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.haseef4.R;
import com.example.haseef4.StaffHome;
import com.example.haseef4.displayProducts.ViewPagerAdapter;
import com.example.haseef4.displayProducts.product;
import com.example.haseef4.displayProducts.productModel;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

//import com.example.haseef4.ui.main.SectionsPagerAdapter;

public class restock extends AppCompatActivity {
    ListView productList;
    DatabaseReference Pref;
    ArrayList<productModel> Plist;
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        tabLayout = (TabLayout) findViewById(R.id.tabs2);
        viewPager = (ViewPager) findViewById(R.id.view_pager2);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new restockfragment1(), "Dairy products");
        viewPagerAdapter.addFragment(new restockfragment2(), "Juices");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);}

//        ImageView back_icons = findViewById(R.id.back);
//
////testsss
//        back_icons.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(restock.this, StaffHome.class));
//            }
//        });
//    }


//}
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
    }
