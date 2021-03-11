package com.example.haseef4;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ListView;
//
//import com.example.haseef4.displayProducts.productModelArduino;
//import com.example.haseef4.displayProducts.product_adapterArduino;
//
//import java.util.ArrayList;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ListView;
//
//import com.example.haseef4.displayProducts.productModel;
//import com.example.haseef4.displayProducts.productModelArduino;
//import com.example.haseef4.displayProducts.product_adapter;
//import com.example.haseef4.displayProducts.product_adapterArduino;
//
//import java.util.ArrayList;
//public class notifaction_Arduino extends AppCompatActivity {
//    ListView list;
//    public static ArrayList<productModelArduino> toNotifyProductsArduino = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notifaction__arduino2);
//
//        list = (ListView) findViewById(R.id.toNotify_listview);
//
//        product_adapterArduino adapter = new product_adapterArduino(getBaseContext(), toNotifyProductsArduino);
//        list.setAdapter(adapter);
//
//        ImageView back_icons = findViewById(R.id.back);
//        back_icons.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//    }



