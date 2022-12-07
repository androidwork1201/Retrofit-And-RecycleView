package com.example.retrofitdemo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.Client.ApiClient;
import com.example.retrofitdemo.JsonObject.CardItem;
import com.example.retrofitdemo.R;
import com.squareup.picasso.Picasso;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    Context context;
    List<CardItem> cardItemList;

    public CardAdapter(Context context, List<CardItem> cardItemList){
        this.context = context;
        this.cardItemList = cardItemList;
    }


    public void SetCardList(List<CardItem> cardItemList){
        this.cardItemList = cardItemList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardItem cardItem = cardItemList.get(position);
        String imageUrl = cardItem.getUrl();
        Picasso.get()
                .load(imageUrl)
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (cardItemList != null){
            return cardItemList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
