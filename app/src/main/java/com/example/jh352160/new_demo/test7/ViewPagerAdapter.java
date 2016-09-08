package com.example.jh352160.new_demo.test7;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jh352160.new_demo.R;

import java.util.List;

/**
 * Created by jh352160 on 2016/9/7.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<String> imageUrlList;
    private Context context;

    public ViewPagerAdapter(Context context,List<String> imageUrlList){
        this.context=context;
        this.imageUrlList=imageUrlList;
    }

    @Override
    public int getCount() {
        return imageUrlList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(context, R.layout.test7_image,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        TextView textView=(TextView)view.findViewById(R.id.textView);
        Glide.with(context).load(imageUrlList.get(position)).into(imageView);
        textView.setText("position "+position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
