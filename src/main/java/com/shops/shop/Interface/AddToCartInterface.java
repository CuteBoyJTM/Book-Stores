package com.shops.shop.Interface;

public interface AddToCartInterface {
    void addToCart(int user_id,
                   int book_id,
                   int store_id,
                   int number);
    void deleteFromCart(int user_id,
                   int book_id,
                   int store_id);
    double updateChecked(int user_id,
                   int book_id,
                   int store_id,
                   int checked);
}
