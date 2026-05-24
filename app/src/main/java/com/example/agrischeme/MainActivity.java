package com.example.agrischeme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText editemail, editpassword;
    Button loginbutton;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editemail = findViewById(R.id.editemail);
        editpassword = findViewById(R.id.editpassword);
        loginbutton = findViewById(R.id.loginbutton);
        firebaseAuth=FirebaseAuth.getInstance();


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editemail.getText().toString().isEmpty()&&!editpassword.getText().toString().isEmpty())
                {
                    if (!editemail.getText().toString().equals("admin@gmail.com")&&!editpassword.getText().toString().equals("admin@123"))
                    {
                        firebaseAuth.signInWithEmailAndPassword(editemail.getText().toString(),editpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(MainActivity.this, "Email & password is wrong", Toast.LENGTH_SHORT).show();

                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Please Check Email Or Password..", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

                    }
                    else if (editemail.getText().toString().equals("admin@gmail.com")&&editpassword.getText().toString().equals("admin@123"))
                    {

                        startActivity(new Intent(MainActivity.this,addschemeandapplicant.class));

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Please check email or password..", Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "All Fields Are Required...", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
            }







