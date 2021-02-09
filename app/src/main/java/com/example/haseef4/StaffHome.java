package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StaffHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
        ImageView statistic=findViewById(R.id.statistic);
        ImageView statistic_icons=findViewById(R.id.statistic_icons);

        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTostatistic();
            }
        });
        statistic_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTostatistic();
            }
        });
    }
    private void goTostatistic(){
        Intent intent = new Intent(this, statistic.class);
        startActivity(intent);
    }

}