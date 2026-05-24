package com.example.agrischeme;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class schemedetails extends AppCompatActivity {
    Button buttoninsert, buttonviewdata, applyb;
    EditText editscheme, editdate,editdoc;
    ImageView imgupload;
    FirebaseDatabase mDatabase;
    FirebaseStorage mStorage;
    DatabaseReference mRef;
    private static final int Gallary_code=1;
    Uri imageUrl= null;
    ProgressDialog progressDialog;
    DatePickerDialog pickerDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schemedetails);
        buttoninsert = findViewById(R.id.buttoninsert);
        editscheme = findViewById(R.id.editscheme);
        editdate = findViewById(R.id.editdate);
        imgupload = findViewById(R.id.imgupload);
        applyb = findViewById(R.id.applyb);
        editdoc=findViewById(R.id.editdoc);
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("student");
        mStorage=FirebaseStorage.getInstance();
        progressDialog=new ProgressDialog(this);

        editdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                pickerDialog = new DatePickerDialog(schemedetails.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editdate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                pickerDialog.show();
            }
        });
        imgupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gallary_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Gallary_code && requestCode==RESULT_OK)
        {
            imageUrl=data.getData();
            imgupload.setImageURI(imageUrl);
        }
        buttoninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String fn=editscheme.getText().toString();
            String dc=editdoc.getText().toString();
            String dn=editdate.getText().toString();
            final String image=imageUrl !=null ? imageUrl.toString():null;

                if (!(fn.isEmpty() && dc.isEmpty() && dn.isEmpty() && image.isEmpty()))
                {
                    progressDialog.setTitle("uploading...");
                    progressDialog.show();
                    Uri uri=data.getData();
                    StorageReference filepath=mStorage.getReference().child("imagePost").child(uri.getLastPathSegment());
                    filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadurl=taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t=task.getResult().toString();

                                    DatabaseReference newPost=mRef.push();
                                    newPost.child("scheme").setValue(fn);
                                    newPost.child("date").setValue(dn);
                                    newPost.child("doc").setValue(dc);
                                    newPost.child("image").setValue(task.getResult().toString());
                                    progressDialog.dismiss();
                                    Intent intent1=new Intent(schemedetails.this,userlist.class);
                                    startActivity(intent1);
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}
