package com.example.agrischeme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agrischeme.Datamodel.model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class uploadfile extends AppCompatActivity {
    ImageView imagebrowse,imagebrowse1,imagebrowse2 ;
    Uri filepath;
    Button  imageupload;
    TextView textmarque1;

    EditText filetitle,filepan,fileuatara,name,address,phone;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadfile);
        textmarque1=(TextView)findViewById(R.id.textmarque1);
        textmarque1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textmarque1.setSelected(true);
        textmarque1.setSingleLine(true);
        textmarque1.setMarqueeRepeatLimit(-1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("mydocuments");

        filetitle=findViewById(R.id.filetitle);
        filepan=findViewById(R.id.filepan);
        fileuatara=findViewById(R.id.fileuatara);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);

        imagebrowse=findViewById(R.id.imagebrowse);
        imagebrowse1=findViewById(R.id.imagebrowse1);
        imagebrowse2=findViewById(R.id.imagebrowse2);
        imageupload=findViewById(R.id.imageupload);

        imagebrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withContext(getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent=new Intent();
                                intent.setType("application/pdf");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent,"Select Pdf Files"),101);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });
        imagebrowse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withContext(getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent1=new Intent();
                                intent1.setType("application/pdf");
                                intent1.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent1,"Select Pdf Files"),101);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        imagebrowse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withContext(getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent2=new Intent();
                                intent2.setType("application/pdf");
                                intent2.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent2,"Select Pdf Files"),101);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        imageupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processupload(filepath);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101 && resultCode==RESULT_OK)
        {
            filepath=data.getData();
           //imagebrowse.setVisibility(View.INVISIBLE);
           // imagebrowse1.setVisibility(View.INVISIBLE);
            //imagebrowse2.setVisibility(View.INVISIBLE);
        }
    }


    public void processupload(Uri filepath)
    {
        final ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle("File Uploading....!!!");
        pd.show();

        final StorageReference reference=storageReference.child("uploads/"+System.currentTimeMillis()+".pdf");
        reference.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                model obj=new model(name.getText().toString(),address.getText().toString(),phone.getText().toString(),filetitle.getText().toString(),uri.toString(),filepan.getText().toString(),uri.toString(),fileuatara.getText().toString(),uri.toString());
                                databaseReference.child(databaseReference.push().getKey()).setValue(obj);


                                pd.dismiss();
                                Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_LONG).show();

                                imagebrowse.setVisibility(View.VISIBLE);
                                imagebrowse1.setVisibility(View.VISIBLE);
                                imagebrowse2.setVisibility(View.VISIBLE);
                                filetitle.setText("");
                                filepan.setText("");
                                fileuatara.setText("");
                            }
                        });

                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        float percent=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        pd.setMessage("Uploaded :"+(int)percent+"%");
                    }
                });


    }
}