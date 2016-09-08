package com.example.jh352160.new_demo.test7;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/7/14.
 */

public class MyFootView extends TextView implements SwipeLoadMoreTrigger,SwipeTrigger{


    public MyFootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onLoadMore() {
        setText("正在拼命加载数据...");
        setTextColor(getResources().getColor(R.color.black));
    }

    @Override
    public void onPrepare() {
        setText("松开加载更多");
        setTextColor(getResources().getColor(R.color.black));
    }

    @Override
    public void onSwipe(int i, boolean b) {
        setText("向下滑动加载更多");
        setTextColor(getResources().getColor(R.color.black));
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void complete() {
        setText("加载完成");
        setTextColor(getResources().getColor(R.color.black));
    }

    @Override
    public void onReset() {

    }
}
