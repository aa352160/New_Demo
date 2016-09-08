package com.example.jh352160.new_demo.test3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/8/23.
 */

public class Test3 extends AppCompatActivity{

    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentStatePagerAdapter adapter=new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return new TestFragment(position);
            }

            @Override
            public int getCount() {
                return 5;
            }
        };
        viewPager.setAdapter(adapter);
    }
}
