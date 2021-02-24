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
import com.google.android.material.snackbar.Snackbar;
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


    public Uri imageUri;
    private ImageView imageview;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    DatabaseReference productDbRef;


   // @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproducts);

        adproduct=findViewById(R.id.adproduct);
        addcompany = findViewById(R.id.addcompany);
        addlocation= findViewById(R.id.addlocation);
        addid=findViewById(R.id.addid);


        btnInsertData = findViewById(R.id.btInsertData);
        storage = FirebaseStorage.getInstance();
        imageview= findViewById(R.id.imageview);
        storageReference  =storage.getReference();
        productDbRef= FirebaseDatabase.getInstance().getReference().child("products");
        // method for chooseing pic
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();

            }
        });
        // method to insaert pic
        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertProducttData();



            }
        });
    }
    // method implemted for upload file**
        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==1 && resultCode==RESULT_OK&& data!=null && data.getData()!=null){
                imageUri = data.getData();
                imageview.setImageURI(imageUri);
                uploadPicture();
            }


        }

        // عرف اللمتعيرات عشان اقدر اعكتب عليها + الصوره
    private void insertProducttData() {
       String product_name=adproduct.getText().toString();
       String product_type = addcompany.getText().toString();
       String product_location= addlocation.getText().toString();
       String producrt_id= addid.getText().toString();
       productadd addp= new productadd(product_name,product_type , product_location , producrt_id);
       productDbRef.push().setValue(addp);
       Toast.makeText(addproducts.this,"Data insert",Toast.LENGTH_SHORT).show();
    }



    // for choosinh insaide
    private void choosePicture(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }




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