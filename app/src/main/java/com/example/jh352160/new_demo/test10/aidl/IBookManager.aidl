package com.example.jh352160.new_demo.test10.aidl;

import com.example.jh352160.new_demo.test10.aidl.Book;
interface IBookManager{
    List<Book> getBookList();
    void addBook(in Book book);
}