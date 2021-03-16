package com.example.haseef4.displayProducts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
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
import com.example.haseef4.editStaff;
import com.example.haseef4.staffModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class productAdapterStaff extends ArrayAdapter<productModel> {
    TextView productName, productRestock,productCompany, productID,product_number;
    ImageView imageView;
    DatabaseReference PRef;

    public productAdapterStaff (Context context, ArrayList<productModel> products){
        super(context, 0, products);
        PRef = FirebaseDatabase.getInstance().getReference().child("products");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        productModel P = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product_staff, parent, false);
        }
        productName = (TextView) convertView.findViewById(R.id.productNameStaff);
        productCompany=(TextView)convertView.findViewById(R.id.productCompanyStaff);
        productID = (TextView) convertView.findViewById(R.id.productIDStaff);
        productRestock = (TextView) convertView.findViewById(R.id.productRestockStaff);
        product_number = (TextView) convertView.findViewById(R.id.productNumberStaff);
        imageView = convertView.findViewById(R.id.productImageStaff);


        productName.setText(P.getName());
        productCompany.setText(P.getCompany());
        productID.setText(P.getProduct_id());
        productRestock.setText(String.valueOf(P.getRestock()));
        //product_number.setText(P.getProduct_number());
        Picasso.get().load(P.getImage()).into(imageView);
//        ByteArrayOutputStream bs = new ByteArrayOutputStream();
//        byte[] b = P.getImage().getBytes();
//        final Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
//        bitmap.compress(Bitmap.CompressFormat.PNG,50,bs);




        return convertView;

    }
}