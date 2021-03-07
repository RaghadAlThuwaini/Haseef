package com.example.haseef4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class addStaff extends AppCompatActivity {

    EditText staffname;
    EditText staffid;
    EditText workingsince;
    EditText Sage;
    EditText slocation;
    Button insertstaff, addStaff;
    ImageView image;
    DatabaseReference staffDB;

    private ImageView profilePic;
    public Uri imageUri;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    DatabaseReference staffDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        staffname = findViewById(R.id.staffnametext);
        staffid = findViewById(R.id.staffidtext);
        workingsince = findViewById(R.id.workingsincetext);
        Sage = findViewById(R.id.agetext);
        slocation = findViewById(R.id.locationtext);
        insertstaff = findViewById(R.id.insertstaff);
        image = findViewById(R.id.imageView2);
        addStaff = findViewById(R.id.addStaff);
        profilePic=findViewById(R.id.staffimage);
        staffDB = FirebaseDatabase.getInstance().getReference().child("staff");
        ImageView back_icons = findViewById(R.id.back);

        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();

        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        insertstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStaffData();
            }
        });

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();
            }
        });
    }

    private void choosePicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            profilePic.setImageURI(imageUri);
            uploadPicture();
        }
    }

    private void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this );
        pd.setTitle("uploading image ");
        pd.show();

        final String randomKey = UUID.randomUUID().toString();
        //  Uri file =Uri.fromFile(new File("path/to/image/rivers.jpg"));
        StorageReference riverRef= storageReference.child("imageg"+ randomKey);

        riverRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content),"image upload",Snackbar.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(),"Faild to up load ",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        double progressPercent = (100.00* taskSnapshot.getBytesTransferred()/ taskSnapshot.getTotalByteCount());
                        pd.setMessage("percent "+(int) progressPercent+"9");
                    }
                });

    }




    public void insertStaffData(){
        String age=staffname.getText().toString();
        String location=slocation.getText().toString();
        String staffName=staffname.getText().toString();
        String working_since=workingsince.getText().toString();
        String staffID=staffid.getText().toString();
        staffModel s=new staffModel(age,location,staffID,staffName,working_since);
        staffDB.push().setValue(s);
        Toast.makeText(addStaff.this,"Staff Added",Toast.LENGTH_SHORT).show();
    }
}


