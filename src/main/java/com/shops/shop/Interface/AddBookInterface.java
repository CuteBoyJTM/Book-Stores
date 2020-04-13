package com.shops.shop.Interface;

public interface AddBookInterface {
    void addBook(String name,String author,String theme,int publisher_id,int pages,double proportion,String photo);
    void deleteBook(int id);
    void ReviseBook(int id,String name,String author,String theme,int publisher_id,int pages,double proportion,String photo);
}
