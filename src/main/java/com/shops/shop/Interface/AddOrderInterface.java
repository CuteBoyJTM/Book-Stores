package com.shops.shop.Interface;

public interface AddOrderInterface {
    void addOrder(int order_id,
                  int user_id);
    void addOrderContent(int order_id,
                         int book_id,
                         int store_id,
                         int book_number);
    void cancelOrder(int order_id);
}
