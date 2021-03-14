package com.example.haseef4.displayProducts;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.haseef4.R;
import com.example.haseef4.staffModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class product_adapterArduino extends ArrayAdapter<productModelArduino> {
    TextView productName, productRestock,productCompany, productID,product_number;
    ImageView imageView;
    DatabaseReference PRef;
    ImageButton delete, edit;
    public product_adapterArduino (Context context, ArrayList<productModelArduino> products){
        super(context, 0, products);
        PRef = FirebaseDatabase.getInstance().getReference().child("productArduino");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        productModelArduino P = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);
        }
        productName = (TextView) convertView.findViewById(R.id.productName);
        productCompany=(TextView)convertView.findViewById(R.id.productCompany);
        productID = (TextView) convertView.findViewById(R.id.productID);
        productRestock = (TextView) convertView.findViewById(R.id.productRestock);
       // product_number = (TextView) convertView.findViewById(R.id.productNumber);
        imageView = convertView.findViewById(R.id.productImage);


        productName.setText(P.getName());
        productCompany.setText(P.getCompany());
        productID.setText(P.getProduct_id());
        productRestock.setText(String.valueOf(P.getRestock()));
       // product_number.setText(P.getProduct_number());
        Picasso.get().load(P.getImage()).into(imageView);
        delete=convertView.findViewById(R.id.deleteBtnProduct);
        edit=convertView.findViewById(R.id.editBtnProduct);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PRef.child(P.getProduct_id()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "product deleted", LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Error", LENGTH_LONG).show();
                    }


                });
            } });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(getContext(), editProduct.class);
                editIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                editIntent.putExtra("company", P.getCompany());
                editIntent.putExtra("Image", P.getImage());
                //editIntent.putExtra("age", P.getLocation());
                editIntent.putExtra("name", P.getName());
                editIntent.putExtra("product_id", P.getProduct_id());
                editIntent.putExtra("Restock", P.getRestock());
                getContext().startActivity(editIntent);
            }
        });

        return convertView;

    }
}
