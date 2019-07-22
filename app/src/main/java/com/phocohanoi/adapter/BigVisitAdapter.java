package com.phocohanoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.phocohanoi.R;
import com.phocohanoi.model.BigVisit;

import java.util.List;

public class BigVisitAdapter extends RecyclerView.Adapter<BigVisitAdapter.MyViewHolder> {


    private Context mContext;
    private List<BigVisit> listBigVisit;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgBig;
        public TextView name, type, address;

        public MyViewHolder(View view) {
            super(view);

            imgBig = (ImageView) view.findViewById(R.id.imgBig);
            type = (TextView) view.findViewById(R.id.tvType);
            name = (TextView) view.findViewById(R.id.tvName);
            address = (TextView) view.findViewById(R.id.tvAddress);
        }
    }

    public BigVisitAdapter(Context mContext, List<BigVisit> listBigVisit) {
        this.mContext = mContext;
        this.listBigVisit = listBigVisit;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_big_visit, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BigVisit bigVisit = listBigVisit.get(position);
        Glide.with(mContext).load(bigVisit.getImgUrl()).into(holder.imgBig);
        holder.type.setText(bigVisit.getType());
        holder.name.setText(bigVisit.getName());
        holder.address.setText(bigVisit.getAddress());
    }

    @Override
    public int getItemCount() {
        return listBigVisit.size();
    }


}
