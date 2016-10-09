package com.example.jh352160.new_demo.test10;

import android.os.Parcel;

/**
 * Created by jh352160 on 2016/10/9.
 */

public class InputTxtFilter extends TestData{

    protected InputTxtFilter(Parcel in) {
        super(in);
    }

    public InputTxtFilter(int userId, String userName, boolean isMale) {
        super(userId, userName, isMale);
    }
}
