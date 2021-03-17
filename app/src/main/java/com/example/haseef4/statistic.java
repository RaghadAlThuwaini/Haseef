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
        Button bestDay = findViewById(R.id.best1);
        Button bestMonth = findViewById(R.id.bestM);
        Button bestYear = findViewById(R.id.bestY);
        ///////
        Button leastDay = findViewById(R.id.leastD);
        Button leastMonth = findViewById(R.id.leasetM);
        Button leastYear = findViewById(R.id.leastY);
        ///////
        bestDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(statistic.this, popUpWindow.class));
            }
        });
        bestMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(statistic.this, popUpWindow2.class));
            }
        });
        bestYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(statistic.this, popUpWindow3.class));
            }
        });
        leastDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(statistic.this, popUpWindow4.class));
            }
        });
        leastMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(statistic.this, popUpWindow5.class));
            }
        });
        leastYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(statistic.this, popUpWindow6.class));
            }
        });

        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                type = Login.cu;
//                if(type.equals("Admin")) {
//                    startActivity(new Intent(statistic.this, AdminHome.class));
//                }
//                else
//                    startActivity(new Intent(statistic.this, StaffHome.class));
            }
        });
    }

}

