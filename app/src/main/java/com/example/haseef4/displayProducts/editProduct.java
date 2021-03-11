package com.example.haseef4.displayProducts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.haseef4.R;
import com.example.haseef4.editStaff;
import com.example.haseef4.staffModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class editProduct extends AppCompatActivity {

    String name, ID, restock, company;
    ImageView imageView;
    TextInputEditText nameIn, IDIn, restockIn, companyIn, imageIn;
    DatabaseReference PRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

            PRef = FirebaseDatabase.getInstance().getReference();
            //get from previous intent
            name = getIntent().getExtras().getString("name");
            ID = getIntent().getExtras().getString("product_id");
            restock = getIntent().getExtras().getString("Restock");
            company = getIntent().getExtras().getString("company");
           imageView = findViewById(R.id.imageView3);
           Drawable drawable= imageView.getDrawable();
            // workingSince = getIntent().getExtras().getString("workingSince");

            //catch txt input from editStaff.xml
            nameIn = findViewById(R.id.ProductNameEdit);
            IDIn = findViewById(R.id.ProductIDEdit);
            restockIn = findViewById(R.id.RestockEdit);
            companyIn = findViewById(R.id.companyEdit);

            //imageIn = findViewById(R.id.staffAgeEdit);
            // set txt input of editStaff.xml to the previous intent's values
            nameIn.setText(name);
            IDIn.setText(ID);
            restockIn.setText(restock);
            companyIn.setText(company);

          //  imageIn.setText(age);

            ImageView back_icons = findViewById(R.id.back);
            back_icons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }
        public void update (View view){
            String productName, comapnyProdcut,image;
            long restockProduct;
            productName = String.valueOf(nameIn.getText());
            restockProduct = Integer.parseInt(String.valueOf(restockIn.getText()));
            comapnyProdcut = String.valueOf(companyIn.getText());

            productModel p = new productModel(productName,  comapnyProdcut, restockProduct);
           // Picasso.get().load(s.getImage()).into(imageView);
            p.setProduct_id(ID);
           // String loction = PRef.child("products").child()
            Query QueryChocolate = PRef.orderByChild("product_id").equalTo(ID).limitToFirst(1);
            QueryChocolate.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    PRef.child("products").child("Chocolate").child(ID).setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(editProduct.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });

            Query QueryDairyProducts = PRef.orderByChild("product_id").equalTo(ID).limitToFirst(1);
            QueryDairyProducts.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    PRef.child("products").child("dairyProducts").child(ID).setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(editProduct.this, "Update successfully ", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });
            Query QueryJuices = PRef.orderByChild("product_id").equalTo(ID).limitToFirst(1);
            QueryJuices.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    PRef.child("products").child("Juices").child(ID).setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(editProduct.this, "Update successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });

        // DatabaseReference locationRef= FirebaseDatabase.getInstance().getReference();
//            staffName = nameIn.getText().toString();
//            restockProduct = restockIn.getText().toString();
//            comapnyProdcut = companyIn.getText().toString();
//            productModel s = new productModel(staffName,  comapnyProdcut, restockProduct);
//            s.setProduct_id(ID);
          // String location2=locationRef.child(s.getProduct_id()).getParent().toString();

           // PRef.child("products").child(loction).child(ID).setValue(s).addOnSuccessListener(new OnSuccessListener<Void>() {


        }
    }




