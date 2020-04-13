package com.shops.shop.Interface;

public interface AddOrderInterface {
    void addOrder(int type,
                  int order_id,
                  int user_id,
                  int receiving_address_id);
    void addOrderContent(int order_id,
                         int book_id,
                         int store_id,
                         int book_number);
    void cancelOrder(int order_id);
}
