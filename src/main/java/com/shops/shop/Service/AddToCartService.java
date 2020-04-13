package com.shops.shop.Service;

import com.shops.shop.DatabaseController.AddToCartDao;
import com.shops.shop.Interface.AddToCartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToCartService implements AddToCartInterface {
    @Autowired
    AddToCartDao addToCartDao;
    @Override
    public void addToCart(int user_id,
                          int book_id,
                          int store_id,
                          int number){
        addToCartDao.addToCart(user_id, book_id, store_id, number);
    };
    @Override
    public void deleteFromCart(int user_id,
                               int book_id,
                               int store_id){
        addToCartDao.deleteFromCart(user_id, book_id, store_id);
    };
    @Override
    public double updateChecked(int user_id,
                              int book_id,
                              int store_id,
                              int checked){
        return addToCartDao.updateChecked(user_id, book_id, store_id, checked);
    };
}
