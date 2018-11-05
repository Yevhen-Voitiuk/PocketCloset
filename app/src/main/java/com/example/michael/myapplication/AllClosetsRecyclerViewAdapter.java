package com.example.michael.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class AllClosetsRecyclerViewAdapter extends RecyclerView.Adapter<AllClosetsRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Closet> mData;

    public AllClosetsRecyclerViewAdapter(Context mContext, List<Closet> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_closet, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, final int i) {

        viewHolder.tv_closet_title.setText(mData.get(i).getClosetName());
        viewHolder.img_closet_thumbnail.setImageResource(mData.get(i).getThumbnail());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mContext, OneClosetActivity.class);
                intent.putExtra("Name", mData.get(i).getClosetName());
                intent.putExtra("J", mData.get(i).getType());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_closet_title;
        ImageView img_closet_thumbnail;
        CardView cardView;

        public MyViewHolder(View closetView) {
            super(closetView);

            tv_closet_title = (TextView) itemView.findViewById(R.id.specific_closet_id);
            img_closet_thumbnail = (ImageView) itemView.findViewById(R.id.specific_closet_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
