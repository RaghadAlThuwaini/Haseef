package com.example.haseef4.displayRestock;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.haseef4.R;
import com.example.haseef4.StaffHome;
import com.example.haseef4.displayProducts.ViewPagerAdapter;
import com.example.haseef4.displayProducts.product;
import com.example.haseef4.displayProducts.productModel;
import com.example.haseef4.displayProducts.product_adapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import okhttp3.internal.cache.DiskLruCache;

//import com.example.haseef4.ui.main.SectionsPagerAdapter;

public class restock extends AppCompatActivity {
    ListView productList;
    DatabaseReference Pref,Sref;
    ArrayList<productModel> Plist;
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    productModel P;
    String sensor;
    float weighted, itemWeight;
    String itemsLeft;
    static ArrayList<productModel> toNotifyProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

//        Sref = FirebaseDatabase.getInstance().getReference("Sensors");
//        Pref = FirebaseDatabase.getInstance().getReference("products");
//
//        Pref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot productSnapshot: snapshot.getChildren()){
//                    P= productSnapshot.getValue(productModel.class);
//                    sensor = P.getSensor();
//
//                    Query getWeight = Sref.child(sensor).child("Weight").orderByValue();
//
//                    getWeight.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
////                            for(DataSnapshot weightSnapshot: snapshot.getChildren()){
//                                weighted = snapshot.getValue(Float.class);
//                                itemWeight = P.getWeight();
//                                itemsLeft = String.valueOf(weighted/itemWeight);
//                                P.setRestock(Long.valueOf(itemsLeft));
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });



        tabLayout = (TabLayout) findViewById(R.id.tabs2);
        viewPager = (ViewPager) findViewById(R.id.view_pager2);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new restockfragment1(), "Dairy products");
        viewPagerAdapter.addFragment(new restockfragment2(), "Juices");
        viewPagerAdapter.addFragment(new restockfragment3(), "Chocolate");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


//}
//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
//
//
//}
//
//
    }
