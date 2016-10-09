package com.example.jh352160.new_demo.test10.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

/**
 * Created by jh352160 on 2016/10/8.
 */

public class Book implements Parcelable {

    public int bookId;
    public String bookName;
    public ArrayAdapter listView;

    public Book(int bookId,String bookName){
        listView.notifyDataSetChanged();
        this.bookId=bookId;
        this.bookName=bookName;
    }

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }
}
