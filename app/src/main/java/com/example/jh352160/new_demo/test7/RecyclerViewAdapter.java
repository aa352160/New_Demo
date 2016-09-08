package com.example.jh352160.new_demo.test7;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jh352160.new_demo.R;

import java.util.List;

/**
 * Created by jh352160 on 2016/8/19.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter{

    List<String> imageUrls;
    Context context;

    public RecyclerViewAdapter(Context context, List<String> imageUrls){
        this.imageUrls=imageUrls;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ImageView imageView=new ImageView(context);
        View view= View.inflate(context, R.layout.test7_image,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //加入占位符可解决图片未加载完成时高度为0的问题
        Glide.with(context).load(imageUrls.get(position)).placeholder(R.drawable.background1).into(((ViewHolder)holder).imageView);
        ((ViewHolder)holder).textView.setText("image "+position);
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            textView=(TextView)itemView.findViewById(R.id.textView);
        }
    }
}
