package com.example.haseef4.displayProducts;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.haseef4.R;
import com.example.haseef4.staffModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class product_adapterArduino extends ArrayAdapter<productModelArduino> {
    TextView productName, productRestock,productCompany, productID,product_number;
    ImageView imageView;
    DatabaseReference PRef;
    public product_adapterArduino (Context context, ArrayList<productModelArduino> products){
        super(context, 0, products);
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
        productID.setText(P.getProducts_id());
        productRestock.setText(String.valueOf(P.getRestock()));
       // product_number.setText(P.getProduct_number());
        Picasso.get().load(P.getImage()).into(imageView);

        return convertView;

    }
}
