package com.shops.shop.Service;

import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.Stores;
import com.shops.shop.Bean.Total;
import com.shops.shop.DatabaseController.GetCartDao;
import com.shops.shop.Interface.GetCartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCartService implements GetCartInterface {
    @Autowired
    GetCartDao getCartDao;
    @Override
    public List<Books> getCartBooks(int user_id, int store_id){
        return getCartDao.getCartBooks(user_id, store_id);
    };
    @Override
    public List<Stores> getCartStores(int user_id){
        return getCartDao.getCartStores(user_id);
    };
    @Override
    public Total getCartInfo(int user_id){
        return getCartDao.getCartInfo(user_id);
    };
    @Override
    public int getCartCount(int user_id){
        return getCartDao.getCartCount(user_id);
    };
}
