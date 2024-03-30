package com.example.food4thought;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{


    ArrayList<Userfood> mList;
    Context context;

    public OurAdapter(ArrayList<Userfood> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);

        return new OurAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Userfood vacancy1 = mList.get(position);
        holder.txtbname.setText("User Name "+vacancy1.getHotelname());
        holder.txtaddress.setText("Time "+vacancy1.getTime());
        holder.txttype.setText("Address "+vacancy1.getAddress());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),productdetails.class);

                intent.putExtra("name", vacancy1.getHotelname());
                intent.putExtra("sabji",vacancy1.getSabji());
                intent.putExtra("dal",vacancy1.getDal());
                intent.putExtra("address",vacancy1.getAddress());
                intent.putExtra("chpati",vacancy1.getChapati());
                intent.putExtra("time",vacancy1.getTime());
                intent.putExtra("number",vacancy1.getNumber());


                v.getContext().startActivity(intent);
            }
        });
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
