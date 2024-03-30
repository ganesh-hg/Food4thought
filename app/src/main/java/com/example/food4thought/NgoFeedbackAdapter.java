package com.example.food4thought;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NgoFeedbackAdapter extends RecyclerView.Adapter<NgoFeedbackAdapter.ViewHolder>{


    ArrayList<Ngofeed> mList;
    Context context;

    public NgoFeedbackAdapter(ArrayList<Ngofeed> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);

        return new NgoFeedbackAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ngofeed vacancy1 = mList.get(position);
        holder.txtbname.setText("Hotel Name "+vacancy1.getHname());
        holder.txtaddress.setText("Address "+vacancy1.getAddress());
        holder.txttype.setText("Feedback "+vacancy1.getFeedback());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView img1;
        TextView txtbname,txtaddress,txttype;
        RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);
            relativeLayout = itemView.findViewById(R.id.relative);
        }
    }
}
