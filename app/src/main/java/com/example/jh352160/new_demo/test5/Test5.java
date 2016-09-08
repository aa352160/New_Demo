package com.example.jh352160.new_demo.test5;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import com.example.jh352160.new_demo.R;
import com.example.jh352160.new_demo.databinding.Test5Binding;

/**
 * Created by jh352160 on 2016/9/5.
 */

public class Test5 extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Test5Binding bingding= DataBindingUtil.setContentView(this, R.layout.test5);

        User user=new User("firstname","lastname");
        bingding.setUser(user);

        String text="您已经连续走了5963步";
        int start=text.indexOf('5');
        int end= text.length();
        Spannable textSpan=new SpannableStringBuilder(text);
        textSpan.setSpan(new AbsoluteSizeSpan(50),0,start, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(80),start,end-1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(50),end-1,end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textView=(TextView)findViewById(R.id.textView);
        textView.setText(textSpan);
    }
}
