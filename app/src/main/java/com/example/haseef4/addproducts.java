package com.example.haseef4;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.haseef4.ui.main.productadd;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class addproducts extends AppCompatActivity {

    EditText adproduct;
    EditText addcompany;
    EditText addlocation;
    EditText addid;
    Button btnInsertData;
    Button adchocolate;
    Button btInsertDataJuices;


    public Uri imageUri;
    private ImageView imgview;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    DatabaseReference productDbRef;
    FirebaseStorage mStorageRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproducts);

        adproduct=findViewById(R.id.adproduct);
        addcompany = findViewById(R.id.addcompany);
        addlocation= findViewById(R.id.addlocation);
        addid=findViewById(R.id.addid);
//        mStorageRef = FirebaseStorage.getInstance("image");
        adchocolate = findViewById(R.id.adchocolate);
        btInsertDataJuices=findViewById(R.id.btInsertDataJuices);
        btnInsertData = findViewById(R.id.btInsertData);
        storage = FirebaseStorage.getInstance();
        imgview= findViewById(R.id.imgview);
        storageReference  =storage.getReference();
        productDbRef= FirebaseDatabase.getInstance().getReference().child("products");
        // method for chooseing pic
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();

            }
            private void choosePicture(){
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,1);

            }

        });
        ImageView back_icons = findViewById(R.id.back);
        back_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ImageView notifications = findViewById(R.id.notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNotification();
            }
        });
        // method to insaert milk
        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mproduct = adproduct.getText().toString();
                String  mcompany= addcompany.getText().toString();
                String mlocation = addlocation.getText().toString();
                String mid= addid.getText().toString();
                productadd addp= new productadd(mproduct,mcompany,mlocation,mid);
                productDbRef.child("dairyProducts").child(mproduct).setValue(addp);
                Toast.makeText(addproducts.this,"insert at dairyProducts ",Toast.LENGTH_LONG).show();
               // insertProducttData();



            }
        });
        adchocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chproduct = adproduct.getText().toString();
                String  chcompany= addcompany.getText().toString();
                String chlocation = addlocation.getText().toString();
                String chid= addid.getText().toString();
                productadd addp= new productadd(chproduct,chcompany,chlocation,chid);
                productDbRef.child("Chocolate").child(chproduct).setValue(addp);
                Toast.makeText(addproducts.this,"insert at chocolate ",Toast.LENGTH_LONG).show();

            }
        });
        btInsertDataJuices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String juproduct = adproduct.getText().toString();
                String  jucompany= addcompany.getText().toString();
                String julocation = addlocation.getText().toString();
                String juid= addid.getText().toString();
                productadd addp= new productadd(juproduct,jucompany,julocation,juid);
                productDbRef.child("Juices").child(juproduct).setValue(addp);
                Toast.makeText(addproducts.this,"insert at juices ",Toast.LENGTH_LONG).show();

            }
        });


    }
    // method implemted for upload file**
        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==1 && resultCode==RESULT_OK&& data!=null && data.getData()!=null){
                imageUri = data.getData();
                imgview.setImageURI(imageUri);
                uploadPicture();
            }


        }

        // عرف اللمتعيرات عشان اقدر اعكتب عليها + الصوره
   /* private void insertProducttData() {
       String product_name=adproduct.getText().toString();
       String product_type = addcompany.getText().toString();
       String product_location= addlocation.getText().toString();
       String producrt_id= addid.getText().toString();
       productadd addp= new productadd(product_name,product_type , product_location , producrt_id);
       productDbRef.push().setValue(addp);
       Toast.makeText(addproducts.this,"Data insert",Toast.LENGTH_SHORT).show();
    }*/







    // method foe bring the pic from the divace**
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
                     //   Snackbar.make(findViewById(android.R.id.content),"image upload",Snackbar.LENGTH_LONG).show();

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
    // for choosinh insaide



    public void goToAddStaff(){
        Intent intent = new Intent(this, addStaff.class);
        startActivity(intent);
    }
    public void goToNotification(){
        startActivity(new Intent(this, notification.class));
    }

}


