package com.example.jh352160.new_demo.test2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jh352160.new_demo.R;

import java.util.List;

/**
 * Created by jh352160 on 2016/8/19.
 */

public class ListSecondeAdapter extends RecyclerView.Adapter{

    List<String> imageUrls;
    Context context;

    public ListSecondeAdapter(Context context,List<String> imageUrls){
        this.imageUrls=imageUrls;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView=new ImageView(context);
        return new ViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(imageUrls.get(position)).placeholder(R.drawable.background).into(((ViewHolder)holder).imageView);
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView;
        }
    }
}
