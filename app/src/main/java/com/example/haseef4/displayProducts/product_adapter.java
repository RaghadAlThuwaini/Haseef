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

public class product_adapter extends ArrayAdapter<productModel> {
    TextView productName, productRestock,productCompany, productID,product_number;
    ImageView imageView;
    ImageButton  delete , edit;
    DatabaseReference PRef;

    public product_adapter (Context context, ArrayList<productModel> products){
        super(context, 0, products);
        PRef = FirebaseDatabase.getInstance().getReference().child("products");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        productModel P = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);
        }
        productName = (TextView) convertView.findViewById(R.id.productName);
        productCompany=(TextView)convertView.findViewById(R.id.productCompany);
        productID = (TextView) convertView.findViewById(R.id.productID);
        productRestock = (TextView) convertView.findViewById(R.id.productRestock);
        imageView = convertView.findViewById(R.id.productImage);
        delete=convertView.findViewById(R.id.deleteBtnProduct);
        edit=convertView.findViewById(R.id.editBtnProduct);

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
                Drawable image = imageView.getDrawable();
                editIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                editIntent.putExtra("company", P.getCompany());
                editIntent.putExtra("Image", P.getImage());
//                editIntent.putExtra("Image", bs.toByteArray());
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