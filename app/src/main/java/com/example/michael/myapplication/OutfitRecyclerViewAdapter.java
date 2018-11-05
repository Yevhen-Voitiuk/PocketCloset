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

public class OutfitRecyclerViewAdapter extends RecyclerView.Adapter<OutfitRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Entry> mData;

    public OutfitRecyclerViewAdapter(Context mContext, List<Entry> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_outfit_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int i) {

        viewHolder.tv_outfit_title.setText(mData.get(i).getEntryName());
        viewHolder.img_outfit_thumbnail.setImageResource(mData.get(i).getThumbnail());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mContext,AddOutfit.class);
                intent.putExtra("Name", mData.get(i).getEntryName());
                intent.putExtra("Description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Lut enim ad minim " +
                        "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo " +
                        "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum " +
                        "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                        "sunt in culpa qui officiae deserunt mollit anim id est laborum. Lorem ipsum dolor");
                intent.putExtra("Thumbnail", mData.get(i).getThumbnail());

                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_outfit_title;
        ImageView img_outfit_thumbnail;
        CardView cardView;

        public MyViewHolder(View closetView) {
            super(closetView);

            tv_outfit_title = (TextView) itemView.findViewById(R.id.specific_outfit_id);
            img_outfit_thumbnail = (ImageView) itemView.findViewById(R.id.specific_outfit_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
