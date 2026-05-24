package com.example.agrischeme.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrischeme.R;
import com.example.agrischeme.Datamodel.User;
import com.example.agrischeme.registrationrecycler;
import com.example.agrischeme.uploadfile;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    List<User> studentMdlList;


    public Adapter(Context context, List<User>  studentMdlList) {
        this.context = context;
        this. studentMdlList =  studentMdlList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.new_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       User user1=studentMdlList.get(position);
       holder.scheme.setText(user1.getScheme());
       holder.textdoc.setText("Required Documents:"+user1.getDoc());
       holder.date.setText("Valid upto:"+user1.getDate());
       String imageUri=null;
       imageUri=user1.getImage();
       Picasso.get().load(imageUri).into(holder.img);

        holder.applyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentapply=new Intent(context, uploadfile.class);
                intentapply.putExtra("agriId",user1.getScheme());
                context.startActivity(intentapply);
            }
        });

    }

    @Override
    public int getItemCount() {

        return  studentMdlList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  scheme,details,date,textdoc,textmarque1;

        Button applyb;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           scheme=itemView.findViewById(R.id.textname);
           date=itemView.findViewById(R.id.textdate);
            textdoc=itemView.findViewById(R.id.textdoc);
           applyb=itemView.findViewById(R.id.applyb);
           img=itemView.findViewById(R.id.img);;

        }
    }

    }
