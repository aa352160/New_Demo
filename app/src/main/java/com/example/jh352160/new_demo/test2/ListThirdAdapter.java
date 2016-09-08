package com.example.jh352160.new_demo.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jh352160.new_demo.R;

import java.util.List;

/**
 * Created by jh352160 on 2016/8/24.
 */

public class ListThirdAdapter extends BaseAdapter{

    List<String> imageUrls;
    LayoutInflater layoutInflater;
    Context context;

    ListThirdAdapter(Context context,List<String> imageUrls){
        this.imageUrls=imageUrls;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type=getItemViewType(i);
        if(view==null){
            switch (type){
                case 0:
                    ViewHolder1 viewHolder1=new ViewHolder1();
                    view=layoutInflater.inflate(R.layout.list_third_1,null);
                    viewHolder1.imageView=(ImageView)view.findViewById(R.id.imageView);
                    Glide.with(context).load(imageUrls.get(i)).into(viewHolder1.imageView);
                    view.setTag(viewHolder1);
                    break;
                case 1:
                    ViewHolder2 viewHolder2=new ViewHolder2();
                    view=layoutInflater.inflate(R.layout.list_third_2,null);
                    viewHolder2.imageView=(ImageView)view.findViewById(R.id.imageView);
                    Glide.with(context).load(imageUrls.get(i)).into(viewHolder2.imageView);
                    view.setTag(viewHolder2);
                    break;
            }
        }else{
            switch (type){
                case 0:
                    ViewHolder1 viewHolder1=(ViewHolder1)view.getTag();
                    Glide.with(context).load(imageUrls.get(i)).into(viewHolder1.imageView);
                    break;
                case 1:
                    ViewHolder2 viewHolder2=(ViewHolder2)view.getTag();
                    Glide.with(context).load(imageUrls.get(i)).into(viewHolder2.imageView);
                    break;
            }
        }
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2==0?0:1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    class ViewHolder1{
        ImageView imageView;
    }

    class ViewHolder2{
        ImageView imageView;
        TextView textView;
    }
}
