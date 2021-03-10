package com.example.haseef4;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.haseef4.displayProducts.productModel;
import com.example.haseef4.ui.main.productadd;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.material.snackbar.Snackbar;
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
    EditText addrestock;
    EditText addid;
    EditText addImage;
    private ImageView imgview;

    Button btnInsertData;
    Button adchocolate;
    Button btInsertDataJuices;


    public Uri imageUri;

    //private FirebaseStorage storage;
    // private StorageReference storageReference;

    DatabaseReference productDbRef;
    //FirebaseStorage mStorageRef;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("products");
    private StorageReference reference1 = FirebaseStorage.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproducts);

        adproduct = findViewById(R.id.adproduct);
        addcompany = findViewById(R.id.addcompany);
        addrestock = findViewById(R.id.addlocation);
        addid = findViewById(R.id.addid);
//        mStorageRef = FirebaseStorage.getInstance("image");
        adchocolate = findViewById(R.id.adchocolate);
        btInsertDataJuices = findViewById(R.id.btInsertDataJuices);
        btnInsertData = findViewById(R.id.btInsertData);
        //storage = FirebaseStorage.getInstance();
        imgview = findViewById(R.id.imgview);
        //  storageReference  =storage.getReference();
        productDbRef = FirebaseDatabase.getInstance().getReference().child("products");
        // method for chooseing pic

        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallaryIntent = new Intent();
                gallaryIntent.setAction(Intent.ACTION_GET_CONTENT);
                gallaryIntent.setType("image/*");
                startActivityForResult(gallaryIntent, 2);


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

        btInsertDataJuices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadToFirebase(imageUri);
             }
        });
        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadToFirebase3(imageUri);
            }
        });
        adchocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadToFirebase2(imageUri);
            }
        });


        // method to insaert milk
//        btnInsertData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (imageUri != null) {
//                } else {
//                    Toast.makeText(addproducts.this, "please select an image", Toast.LENGTH_SHORT).show();
//                }
//
//                uploadToFirebase(imageUri);
//                String mproduct = adproduct.getText().toString();
//                String mcompany = addcompany.getText().toString();
//                String mlocation = addlocation.getText().toString();
//                String mid = addid.getText().toString();
//                productadd addp = new productadd(mproduct, mcompany, mlocation, mid);
//                productDbRef.child("dairyProducts").child(mproduct).setValue(addp);
//                Toast.makeText(addproducts.this, "insert at dairyProducts ", Toast.LENGTH_LONG).show();
//                // insertProducttData();
//
//
//            }
//        });
//
//
//        btInsertDataJuices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (imageUri != null) {
//                } else {
//                    Toast.makeText(addproducts.this, "please select an image", Toast.LENGTH_SHORT).show();
//                }
//
//                uploadToFirebase(imageUri);
//                String juproduct = adproduct.getText().toString();
//                String jucompany = addcompany.getText().toString();
//                String julocation = addlocation.getText().toString();
//                String juid = addid.getText().toString();
//               // String juImage= addImage.getT
//                productadd addp = new productadd(juproduct, jucompany, julocation, juid);
//                productDbRef.child("Juices").child(juproduct).setValue(addp);
//                Toast.makeText(addproducts.this, "insert at juices ", Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//
    }

    // method implemted for upload file**
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imgview.setImageURI(imageUri);
            // uploadPicture();
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
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("uploading image ");
        pd.show();

        final String randomKey = UUID.randomUUID().toString();
        //  Uri file =Uri.fromFile(new File("path/to/image/rivers.jpg"));
        StorageReference riverRef = reference1.child("image" + randomKey);

        riverRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content), "image upload", Snackbar.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(), "Faild to up load ", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        double progressPercent = (100.00 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                        pd.setMessage("percent " + (int) progressPercent + "9");
                    }
                });

    }
    // for choosinh insaide

    String getImage;

    private void uploadToFirebase(Uri uri) {
        StorageReference btInsertDataJuices = reference1.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        btInsertDataJuices.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                btInsertDataJuices.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String name = adproduct.getText().toString();
                        String compeny = addcompany.getText().toString();
                        String plocation =  addrestock.getText().toString();
                        String id = addid.getText().toString();
                        productModel model = new productModel(name, uri.toString(), compeny, plocation, id);
                        //getImage = model.getImage();
                        productDbRef.child("Juices").child(id).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(addproducts.this,"uploaded successfully  ", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(addproducts.this,"uploaded failed ", Toast.LENGTH_LONG).show();
                            }
                        });

                    }

                });// end juices
            }
        });
    } // end2



    private void uploadToFirebase2(Uri uri) {
        StorageReference adchocolate = reference1.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        adchocolate.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                adchocolate.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String name = adproduct.getText().toString();
                        String compeny = addcompany.getText().toString();
                        String plocation =  addrestock.getText().toString();
                        String id = addid.getText().toString();
                        productModel model = new productModel(name, uri.toString(), compeny, plocation, id);
                        //getImage = model.getImage();
                        productDbRef.child("Chocolate").child(id).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(addproducts.this,"uploaded successfully  ", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(addproducts.this,"uploaded failed ", Toast.LENGTH_LONG).show();
                            }
                        });

                    }

                });// end juices


            }
        });
    } // end2


    private void uploadToFirebase3(Uri uri) {
        StorageReference btnInsertData = reference1.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        btnInsertData.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                btnInsertData.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String name = adproduct.getText().toString();
                        String compeny = addcompany.getText().toString();
                        String plocation =  addrestock.getText().toString();
                        String id = addid.getText().toString();
                        productModel model = new productModel(name, uri.toString(), compeny, plocation, id);
                        //getImage = model.getImage();
                        productDbRef.child("dairyProducts").child(id).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(addproducts.this,"uploaded successfully  ", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(addproducts.this,"uploaded failed ", Toast.LENGTH_LONG).show();
                            }
                        });

                    }

                });// end juices


            }
        });
    } // end2





//                    @Override
//                    public void onSuccess(Uri uri) {
//                        String name=adproduct.getText().toString();
//                        String compeny=addcompany.getText().toString();
//                        String plocation=addlocation.getText().toString();
//                        String id=addid.getText().toString();
//
//                       // productModel p=new productModel(name,uri.toString(),compeny,plocation,id);
//                       // productDbRef.push().setValue(p);
//                        productModel model=new productModel(name,uri.toString(),compeny,plocation,id);
//                        getImage= model.getImage();
////                        productDbRef.child(id).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
////                            @Override
////                            public void onSuccess(Void aVoid) {
////                                Toast.makeText(addproducts.this , " uploaded successfully",Toast.LENGTH_LONG).show();
////                                finish();
////                            }
////                        }).addOnFailureListener(new OnFailureListener() {
////                            @Override
////                            public void onFailure(@NonNull Exception e) {
////                                Toast.makeText(addproducts.this , " Failed",Toast.LENGTH_LONG).show();
////                            }
////                        });
////                        String modelId=root.push().getKey();
////                        root.child(modelId).setValue(model);
//                        //Toast.makeText(addproducts.this , " uploaded successfully",Toast.LENGTH_LONG).show();
//
//                    }
//                });
//
//            }
//        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(addproducts.this , " uploading fail",Toast.LENGTH_LONG).show();
//            }
//        });
//    }


            private String getFileExtension(Uri mUri) {
                ContentResolver cr1 = getContentResolver();
                MimeTypeMap mime = MimeTypeMap.getSingleton();
                return mime.getExtensionFromMimeType(cr1.getType(mUri));
            }







    public void goToAddStaff(){
        Intent intent = new Intent(this, addStaff.class);
        startActivity(intent);
    }
    public void goToNotification(){
        startActivity(new Intent(this, notification.class));
    }

}



