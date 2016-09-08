package com.example.jh352160.new_demo.test2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by jh352160 on 2016/8/19.
 */

public class ListFirstAdapter extends ArrayAdapter<String>{

    Context context;
    List<String> imageIds;

    public ListFirstAdapter(Context context, int resource, List<String> imageIds) {
        super(context,resource,imageIds);
        this.context=context;
        this.imageIds=imageIds;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // TODO: 2016/8/23 improvement code
        View view=null;
        ViewHolder viewholder;
        if (convertView==null){
            viewholder=new ViewHolder();
            viewholder.imageView=new ImageView(context);
            view=viewholder.imageView;
        }else{
            view=convertView;
            //viewholder=(ViewHolder)view.getTag();
        }
        Glide.with(context).load(imageIds.get(position)).into((ImageView)view);
        return view;
    }

    @Override
    public int getCount() {
        return imageIds.size();
    }

    static class ViewHolder{
        ImageView imageView;
    }
}
