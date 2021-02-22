package com.example.haseef4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.haseef4.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

    public class staff_adapter extends ArrayAdapter<staffModel> {
        TextView staffName,staffID,staffAge,staffLocation,staffWorking;
        ImageView imageView;
        ImageButton delete, edit;
        DatabaseReference SRef;
        public staff_adapter (Context context, ArrayList<staffModel> staff){
            super(context, 0, staff);
            SRef = FirebaseDatabase.getInstance().getReference().child("staff");
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            staffModel s = getItem(position);
            if(convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.staff_card, parent, false);
            }
            staffName = (TextView) convertView.findViewById(R.id.staffName);
            staffID = (TextView) convertView.findViewById(R.id.staffID);
            staffAge = (TextView) convertView.findViewById(R.id.staffAge);
            staffLocation = (TextView) convertView.findViewById(R.id.location);
            staffWorking = (TextView) convertView.findViewById(R.id.working);
            imageView = convertView.findViewById(R.id.staffImage);
            delete = convertView.findViewById(R.id.deleteBtn);
            edit = convertView.findViewById(R.id.editBtn);

            staffName.setText(s.getStaffName());
            staffID.setText(s.getStaffID());
            staffAge.setText(s.getAge());
            staffLocation.setText(s.getLocation());
            staffWorking.setText(s.getWorking_since());
           // Picasso.get().load(s.getImage()).into(imageView);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SRef.child(s.getStaffID()).removeValue();
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editIntent = new Intent(getContext(), editStaff.class);
                    editIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    editIntent.putExtra("name", s.getStaffName());
                    editIntent.putExtra("ID", s.getStaffID());
                    editIntent.putExtra("age", s.getAge());
                    editIntent.putExtra("location", s.getLocation());
                    editIntent.putExtra("workingSince", s.getWorking_since());
                    getContext().startActivity(editIntent);
                }
            });
            return convertView;

        }
    }

