package com.example.agrischeme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class useradmin extends AppCompatActivity {
    Button userbutton,adminbutton;
    TextView textmarque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useradmin);
        userbutton=findViewById(R.id.userbutton);
       adminbutton=findViewById(R.id.adminbutton);
        textmarque=(TextView)findViewById(R.id.textmarque);
        textmarque.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textmarque.setSelected(true);
        textmarque.setSingleLine(true);
        textmarque.setMarqueeRepeatLimit(-1);


       userbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            Intent intent2=new Intent(useradmin.this,userlist.class);
            startActivity(intent2);
           }
       });
       adminbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(useradmin.this,MainActivity.class);
               startActivity(intent);

           }
       });


    }
}