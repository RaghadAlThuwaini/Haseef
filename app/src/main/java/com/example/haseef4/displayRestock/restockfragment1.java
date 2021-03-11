package com.example.haseef4.displayRestock;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.haseef4.MainActivity;
import com.example.haseef4.R;
import com.example.haseef4.displayProducts.productModel;
import com.example.haseef4.displayProducts.product_adapter;
import com.example.haseef4.notification;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.haseef4.notification.toNotifyProducts;

public class restockfragment1 extends Fragment {

    ListView productList;
    DatabaseReference DPref;
    DatabaseReference restockEventsRef;
    ArrayList<productModel> dairyPlist;
    //Long restockEvents;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restockfragment1_layout,container,false);
        productList = (ListView) view.findViewById(R.id.dairy_products_restock_view);
        dairyPlist = new ArrayList<>();

        //firebase reference on dairy products
        DPref = FirebaseDatabase.getInstance().getReference().child("products").child("dairyProducts");

        //to get products with <=5 remain items
        Query getRestockProducts = DPref.orderByChild("restock").endAt(5);
        getRestockProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dairyPlist.clear();
                for(DataSnapshot productSnapshot: snapshot.getChildren()){
                    productModel P = productSnapshot.getValue(productModel.class);
                    dairyPlist.add(P);
                    toNotifyProducts.add(P);
                    Triggernotification(P.getName());
                }
                product_adapter adapter = new product_adapter(getContext(), dairyPlist);
                productList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
    private void Triggernotification(String productName){
        NotificationManager manager = ContextCompat.getSystemService(getContext(), NotificationManager.class);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("d", "dairyP", NotificationManager.IMPORTANCE_HIGH);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
//            channel.setShowBadge(true);
//            channel.setBypassDnd(true);
            manager.createNotificationChannel(channel);
        }
        Intent intent = new Intent(getContext(), notification.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP |Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //
        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);

        Intent fullScreenIntent = new Intent(getContext(), notification.class);
        PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(getContext(), 0,
                fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "d")
                .setContentText("Haseef").setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setAutoCancel(true)
                .setContentText(productName+ " product needs to be refilled")
                .setContentIntent(pendingIntent)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setWhen(System.currentTimeMillis())
                .setOnlyAlertOnce(true)
                .setChannelId("d")
                .setFullScreenIntent(fullScreenPendingIntent, true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
        managerCompat.notify(1, builder.build());
    }
    }



