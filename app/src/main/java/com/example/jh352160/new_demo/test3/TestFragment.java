package com.example.jh352160.new_demo.test3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jh352160 on 2016/8/23.
 */

public class TestFragment extends Fragment {

    View view;
    int count = 0;

    public TestFragment() {
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    public TestFragment(int count) {
        this.count = count;
    }

    public static TestFragment newInstance(int count) {
       TestFragment fragment =  new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count",count);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = new TextView(getActivity());
        ((TextView) view).setText("This is " + count);
        return view;
    }
}
