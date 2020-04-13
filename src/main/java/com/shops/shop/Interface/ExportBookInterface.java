package com.shops.shop.Interface;


public interface ExportBookInterface {
    void exportBook(int book_id,int store_id);
    int importBook(int book_id,
                   int store_id,
                   int number,
                   double price);
}
