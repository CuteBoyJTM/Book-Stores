package com.shops.shop.Service;

import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.OrderList;
import com.shops.shop.Bean.Orders;
import com.shops.shop.Bean.Stores;
import com.shops.shop.DatabaseController.GetOrderDao;
import com.shops.shop.Interface.GetOrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrderService implements GetOrderInterface {
    @Autowired
    GetOrderDao getOrderDao;
    @Override
    public List<Books> getOrderBooks(int order_id, int store_id){
        return getOrderDao.getOrderBooks(order_id, store_id);
    };
    @Override
    public List<Stores> getOrderStores(int order_id){
        return getOrderDao.getOrderStores(order_id);
    };
    @Override
    public List<Books> getOrderFirstBook(int order_id){
        return getOrderDao.getOrderFirstBook(order_id);
    };
    @Override
    public List<OrderList> getOrderPaid(int user_id,
                                 int start_subscript,
                                 int pageSize){
        return getOrderDao.getOrderPaid(user_id, start_subscript, pageSize);
    };
    @Override
    public List<OrderList> getOrderToBePaid(int user_id,
                                     int start_subscript,
                                     int pageSize){
        return getOrderDao.getOrderToBePaid(user_id, start_subscript, pageSize);
    };
    @Override
    public List<Orders> getOrder(int order_id){
        return getOrderDao.getOrder(order_id);
    };
}
