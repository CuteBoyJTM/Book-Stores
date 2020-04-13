package com.shops.shop.Interface;

import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.OrderList;
import com.shops.shop.Bean.Orders;
import com.shops.shop.Bean.Stores;

import java.util.List;

public interface GetOrderInterface {
    List<Books> getOrderBooks(int order_id, int store_id);
    List<Stores> getOrderStores(int order_id);
    List<Books> getOrderFirstBook(int order_id);
    List<OrderList> getOrderPaid(int user_id,
                                 int start_subscript,
                                 int pageSize);
    List<OrderList> getOrderToBePaid(int user_id,
                                     int start_subscript,
                                     int pageSize);
    List<Orders> getOrder(int order_id);
}
