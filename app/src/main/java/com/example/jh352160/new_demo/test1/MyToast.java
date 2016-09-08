package com.example.jh352160.new_demo.test1;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/8/19.
 */

public class MyToast {

    private Toast toast;
    private LinearLayout linearLayout;

    public MyToast(){}

    /**
     * 完全自定义布局
     * @param context
     * @param view
     * @param duration
     */
    public MyToast(Context context, View view,int duration){
        toast=new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
    }

    /**
     * 向Toast中添加自定义view
     * @param view
     * @param position
     * @return
     */
    public MyToast addView(View view,int position){
        linearLayout=(LinearLayout)toast.getView();
        linearLayout.addView(view,position);
        return this;
    }

    /**
     * 设置Toast字体及背景颜色
     * @param messageColor
     * @param backgroundColor
     * @return
     */
    public MyToast setToastColor(int messageColor,int backgroundColor){
        View view=toast.getView();
        if (view!=null){
            view.setBackgroundResource(R.color.transparent);
            TextView message=((TextView)view.findViewById(android.R.id.message));
            message.setBackgroundColor(backgroundColor);
            message.setTextColor(messageColor);
        }
        return this;
    }

    /**
     * 设置Toast字体及背景
     * @param messageColor
     * @param background
     * @return
     */
    public MyToast setToastBackground(int messageColor,int background){
        View view=toast.getView();
        if (view!=null){
            TextView message=((TextView)view.findViewById(android.R.id.message));
            message.setBackgroundResource(background);
            message.setTextColor(messageColor);
        }
        return this;
    }

    /**
     * 短时间显示Toast
     * @param context
     * @param message
     * @return
     */
    public MyToast Short(Context context,CharSequence message){
        if (toast==null||(linearLayout!=null&&linearLayout.getChildCount()>1)){
            toast=Toast.makeText(context,message,Toast.LENGTH_SHORT);
            linearLayout=null;
        }else{
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        return this;
    }

    /**
     * 长时间显示Toast
     * @param context
     * @param message
     * @return
     */
    public MyToast Long(Context context,CharSequence message){
        if (toast==null||(linearLayout!=null&&linearLayout.getChildCount()>1)){
            toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
            linearLayout=null;
        }else{
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_LONG);
        }
        return this;
    }

    /**
     * 自定义显示Toast时间
     * @param context
     * @param message
     * @param duration
     * @return
     */
    public MyToast Indefinite(Context context,CharSequence message,int duration){
        if(toast==null||(linearLayout!=null&&linearLayout.getChildCount()>1)){
            toast=Toast.makeText(context,message,duration);
            linearLayout=null;
        }else{
            toast.setText(message);
            toast.setDuration(duration);
        }
        return this;
    }

    /**
     * 显示Toast
     * @return
     */
    public MyToast show(){
        toast.show();
        return this;
    }

    /**
     * 获取Toast
     * @return
     */
    public Toast getToast(){
        return toast;
    }

}
