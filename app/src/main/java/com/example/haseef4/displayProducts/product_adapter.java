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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class product_adapter extends ArrayAdapter<productModel> {
    TextView productName, productRestock;
    ImageView imageView;
    public product_adapter(Context context, ArrayList<productModel> products){
        super(context, 0, products);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        productModel P = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);
        }
            productName = (TextView) convertView.findViewById(R.id.productName);
            productRestock = (TextView) convertView.findViewById(R.id.productRestock);
            imageView = convertView.findViewById(R.id.productImage);

        productName.setText(P.getName());
        productRestock.setText(P.getRestock());
        Picasso.get().load(P.getImage()).into(imageView);

            return convertView;

    }
}
