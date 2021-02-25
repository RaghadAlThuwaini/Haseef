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
private FirebaseStorage storage;
private StorageReference storageRefrence;
private ImageView staffimage;
    public Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);

        staffimage = findViewById(R.id.staffimage);
        storage = FirebaseStorage.getInstance();
        storageRefrence = storage.getReference();

        staffname = findViewById(R.id.staffnametext);
        staffid = findViewById(R.id.staffidtext);
        workingsince = findViewById(R.id.workingsincetext);
        Sage = findViewById(R.id.agetext);
        slocation = findViewById(R.id.locationtext);
        insertstaff = findViewById(R.id.insertstaff);
        image = findViewById(R.id.imageView2);
        addStaff = findViewById(R.id.addStaff);
        staffDB = FirebaseDatabase.getInstance().getReference().child("staff");
        ImageView back_icons = findViewById(R.id.back);
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

            public void insertStaffData() {
                String age = staffname.getText().toString();
                String location = slocation.getText().toString();
                String staffName = staffname.getText().toString();
                String working_since = workingsince.getText().toString();
                String staffID = staffid.getText().toString();
                staffModel s = new staffModel(age, location, staffID, staffName, working_since);
                staffDB.push().setValue(s);
                Toast.makeText(addStaff.this, "Staff Added", Toast.LENGTH_SHORT).show();
            }
        });


//to change the image
        staffimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }


        });
    }

private void chooseImage(){
    Intent intent=new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityIfNeeded(intent,1);
}

protected void onActivityRusult(int reqestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(reqestCode,resultCode,data);
        if(reqestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imageUri=data.getData();
            staffimage.setImageURI(imageUri);
            uploadPicture();
        }




    }

    private void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this );
        pd.setTitle("uploading image ");
        pd.show();

        final String randomKey = UUID.randomUUID().toString();
        //  Uri file =Uri.fromFile(new File("path/to/image/rivers.jpg"));
        StorageReference riverRef= storageRefrence.child("imageg"+ randomKey);

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
    }
