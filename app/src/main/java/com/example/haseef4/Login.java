package com.example.haseef4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//....
public class Login extends AppCompatActivity {
    EditText txtUser , txtPass;
    Button btnLogin;
    Spinner spinner;
    public static String cu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtPass= (EditText)findViewById(R.id.txtPass);
        txtUser= (EditText)findViewById(R.id.txtUser);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        spinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = spinner.getSelectedItem().toString();
                String email = txtUser.getText().toString();
                String password = txtPass.getText().toString();

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()) {
                            boolean isLogin = false;
                            for (DataSnapshot d : snapshot.getChildren()) {
                                Users us = d.getValue(Users.class);
                                if(us.getEmail().equals(email) && us.getPassword().equals(password)){
                                    isLogin = true;
                                }
                            }
                            if(isLogin){
                                if(type.equals("Admin")){
                                    cu = "Admin";
                                    LogedUser.email=email;
                                    goToAdmin();
                                }
                                else{
                                    LogedUser.email=email;
                                    goToStaff();
                                }

                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Invalid email or password", Toast.LENGTH_SHORT).show();

                            }

                        }
                        else
                            Toast.makeText(getApplicationContext(), "no users in database ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        });
    }

    private void goToAdmin(){
        Intent intent = new Intent(this, AdminHome.class);

        startActivity(intent);

    }
    private void goToStaff(){
        Intent intent = new Intent(this, StaffHome.class);
        startActivity(intent);
    }
}