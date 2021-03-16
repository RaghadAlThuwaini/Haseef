package com.example.haseef4.displayProducts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.haseef4.R;
import com.example.haseef4.editStaff;
import com.example.haseef4.staffModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;

public class editProduct extends AppCompatActivity {

    String name, ID, company, image,imageUri;
    ImageView imageView;
    long restock;
    TextInputEditText nameIn, IDIn, restockIn, companyIn;
    DatabaseReference PRef;
    productModel p ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

            PRef = FirebaseDatabase.getInstance().getReference();
            //get from previous intent
            name = getIntent().getExtras().getString("name");
            ID = getIntent().getExtras().getString("product_id");
            restock = getIntent().getExtras().getLong("Restock");
            company = getIntent().getExtras().getString("company");
            image = getIntent().getExtras().getString("Image");


            //catch txt input from editStaff.xml
            nameIn = findViewById(R.id.ProductNameEdit);
            IDIn = findViewById(R.id.ProductIDEdit);
            restockIn = findViewById(R.id.RestockEdit);
            companyIn = findViewById(R.id.companyEdit);
            imageView = findViewById(R.id.productImageEdit);
        Picasso.get().load(image).into(imageView);

        // set txt input of editStaff.xml to the previous intent's values
            nameIn.setText(name);
            IDIn.setText(ID);
            restockIn.setText(String.valueOf(restock));
            companyIn.setText(company);

        ImageView back_icons = findViewById(R.id.back);
            back_icons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        public void update (View view){
            String productName, comapnyProdcut;
            long restockProduct;
            productName = String.valueOf(nameIn.getText());
            restockProduct = Integer.parseInt(String.valueOf(restockIn.getText()));
            comapnyProdcut = String.valueOf(companyIn.getText());
            p = new productModel(productName,  comapnyProdcut, restockProduct,image);
            p.setProduct_id(ID);

            if(ID.startsWith("C")) {
                Query QueryChocolate = PRef.orderByChild("product_id");
                QueryChocolate.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            PRef.child("products").child("Chocolate").child(ID).setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getBaseContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
            }
            //PRef.orderByChild("product_id").equalTo(ID);
            if(ID.startsWith("D")) {
                Query QueryDairyProducts = PRef.orderByChild("product_id");
                QueryDairyProducts.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            PRef.child("productArduino").child("dairyProducts").child(ID).setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getBaseContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
            }
            //PRef.orderByChild("product_id").equalTo(ID).limitToFirst(1);
            if(ID.startsWith("J")) {
                Query QueryJuices = PRef.orderByChild("product_id");
                QueryJuices.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            PRef.child("products").child("Juices").child(ID).setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getBaseContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
            }
        }
    }


