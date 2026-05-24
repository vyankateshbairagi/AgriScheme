package com.example.agrischeme.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrischeme.Datamodel.User;


import com.example.agrischeme.Datamodel.model;
import com.example.agrischeme.R;
import com.example.agrischeme.viewpdf;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;
import java.util.Objects;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, int position, @NonNull final model model) {

        holder.header.setText(model.getFilename());
        holder.textname.setText(model.getName());
        holder.textaddress.setText(model.getAddress());
        holder.textphone.setText(model.getPhone());
        holder.textuatara.setText(model.getUatara());
        holder.textpan.setText(model.getPan());
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.img1.getContext(),viewpdf.class);
                intent.putExtra("filename",model.getFilename());
                intent.putExtra("fileurl",model.getFileurl());
                intent.putExtra("name",model.getName());
                intent.putExtra("adress",model.getAddress());
                intent.putExtra("phone",model.getPhone());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.img1.getContext().startActivity(intent);
            }
        });
        holder.imgpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenta = new Intent(holder.imgpan.getContext(),viewpdf.class);
                intenta.putExtra("pan", model.getPan());
                intenta.putExtra("fileurl1", model.getFileurl1());
                intenta.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.imgpan.getContext().startActivity(intenta);

            }
        });
        holder.imguatara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentr=new Intent(holder.imguatara.getContext(),viewpdf.class);
                intentr.putExtra("uatara",model.getUatara());
                intentr.putExtra("fileurl2",model.getFileurl2());
                intentr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.imguatara.getContext().startActivity(intentr);


            }
        });
        holder.imgapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.imgreject.setVisibility(View.GONE);

            }
        });
        holder.imgreject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgapp.setVisibility(View.GONE);
            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singelrowdesign,parent,false);
        return  new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1,imgpan,imguatara;
        TextView header,textname,textaddress,textphone,textpan,textuatara;
        ImageButton imgapp,imgreject;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);


            header=itemView.findViewById(R.id.header);
            img1=itemView.findViewById(R.id.img1);
            imgpan=itemView.findViewById(R.id.imgpan);
            imguatara=itemView.findViewById(R.id.imguatara);
            header=itemView.findViewById(R.id.header);
            textname=itemView.findViewById(R.id.textname);
            textaddress=itemView.findViewById(R.id.textaddress);
            textphone=itemView.findViewById(R.id.textphone);
            textpan=itemView.findViewById(R.id.textpan);
            textuatara=itemView.findViewById(R.id.textuatara);
            imgapp=itemView.findViewById(R.id.imgapp);
            imgreject=itemView.findViewById(R.id.imgreject);
        }
    }
}
