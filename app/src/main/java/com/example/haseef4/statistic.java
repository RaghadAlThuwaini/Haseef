package com.example.haseef4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import com.example.haseef4.Login;   //عشان نعرف الcurrent user ونوجهه للهوم حقه لما يضغط على سهم back

public class statistic extends AppCompatActivity {
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        ImageView setting_icons = findViewById(R.id.setting);
        ImageView back_icons = findViewById(R.id.back);
        Button b1 = findViewById(R.id.best1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(statistic.this,popUpWindow.class));
            }
        });


        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = Login.cu;
                if(type.equals("Admin")) {
                    startActivity(new Intent(statistic.this, AdminHome.class));
                }
                else
                    startActivity(new Intent(statistic.this, StaffHome.class));
            }
        });
    }


}