package com.example.jh352160.new_demo.test10;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jh352160 on 2016/10/8.
 */

public class TestData implements Parcelable {

    public int userId;
    public String userName;
    public boolean isMale;

    public TestData(int userId,String userName,boolean isMale){
        this.userId=userId;
        this.userName=userName;
        this.isMale=isMale;
    }

    protected TestData(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
    }

    public static final Creator<TestData> CREATOR = new Creator<TestData>() {
        @Override
        public TestData createFromParcel(Parcel in) {
            return new TestData(in);
        }

        @Override
        public TestData[] newArray(int size) {
            return new TestData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
    }

}
