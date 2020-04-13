package com.shops.shop.Service;

import com.shops.shop.DatabaseController.AddOrderDao;
import com.shops.shop.Interface.AddOrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddOrderService implements AddOrderInterface {
    @Autowired
    AddOrderDao addOrderDao;
    @Override
    public void addOrder(int type,
                         int order_id,
                         int user_id,
                         int receiving_address_id){
        addOrderDao.addOrder(type,order_id, user_id,receiving_address_id);
    };
    @Override
    public void addOrderContent(int order_id,
                         int book_id,
                         int store_id,
                         int book_number){
        addOrderDao.addOrderContent(order_id, book_id, store_id, book_number);
    };
    @Override
    public void cancelOrder(int order_id){
        addOrderDao.cancelOrder(order_id);
    };
}
