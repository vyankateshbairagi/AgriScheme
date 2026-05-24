package com.example.agrischeme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.agrischeme.Adapter.Adapter;
import com.example.agrischeme.Adapter.imageadapter;
import com.example.agrischeme.Datamodel.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class userlist extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    FirebaseStorage mStorage;
    DatabaseReference mRef;
    RecyclerView recyclerView;
    Adapter studentAdapter;
    List<User> studentMdlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);


        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        imageadapter adapterView = new imageadapter(this);
        mViewPager.setAdapter(adapterView);

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("student");
        mStorage=FirebaseStorage.getInstance();
        recyclerView=findViewById(R.id.recyclerView);

        studentMdlList=new ArrayList<User>();


        initComponents();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                User studentModel= snapshot.getValue(User.class);
                studentMdlList.add(studentModel);
                studentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void initComponents() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter=new Adapter(userlist.this,studentMdlList);
        recyclerView.setAdapter(studentAdapter);


    }

}