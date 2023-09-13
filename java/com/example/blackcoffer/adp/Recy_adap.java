package com.example.blackcoffer.adp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackcoffer.R;

import java.util.List;

public class Recy_adap extends RecyclerView.Adapter<Recy_adap.explore>{
    @NonNull
    private Context context;
    private List<people> peolst;

    public Recy_adap(@NonNull Context context, List<people> peolst) {
        this.context = context;
        this.peolst = peolst;
    }

    @Override
    public explore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adp_frag,parent,false);
        return new Recy_adap.explore(view);
    }

    @Override
    public void onBindViewHolder(@NonNull explore holder, int position) {
        people peo = peolst.get(position);

        holder.name.setText(peo.name);
        holder.prof.setBackgroundResource(R.drawable.ic_launcher_foreground);
        holder.job.setText(peo.job);
        holder.moti.setText(peo.moti);
        holder.des.setText(peo.desc);
        holder.dis.setText(peo.dis);



    }

    @Override
    public int getItemCount() {
        return peolst.size();
    }

    public class explore extends RecyclerView.ViewHolder{
        private TextView name,job,dis,moti,des;
        private ImageView prof;
        public explore(@NonNull View itemView) {



            super(itemView);
            name= itemView.findViewById(R.id.name);
            job= itemView.findViewById(R.id.jb);
            dis=itemView.findViewById(R.id.dis);
            moti=itemView.findViewById(R.id.moti);
            des=itemView.findViewById(R.id.des);
            prof=itemView.findViewById(R.id.prof);
        }
    }
}
