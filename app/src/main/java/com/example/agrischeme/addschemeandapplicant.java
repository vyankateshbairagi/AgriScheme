package com.example.agrischeme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class addschemeandapplicant extends AppCompatActivity {
    ImageView add,applicant;
    TextView welcome;
    Button btadds,btapplicant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addschemeandapplicant);
        add=findViewById(R.id.add);
        applicant=findViewById(R.id.applicant);
        btadds=findViewById(R.id.btadds);
        btapplicant=findViewById(R.id.btapplicant);
        btadds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenta=new Intent(addschemeandapplicant.this,schemedetails.class);
                startActivity(intenta);
            }
        });
        btapplicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenta=new Intent(addschemeandapplicant.this,registrationrecycler.class);
                startActivity(intenta);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenta=new Intent(addschemeandapplicant.this,schemedetails.class);
                startActivity(intenta);
            }
        });
        applicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenta=new Intent(addschemeandapplicant.this,registrationrecycler.class);
                startActivity(intenta);

            }
        });
    }
}