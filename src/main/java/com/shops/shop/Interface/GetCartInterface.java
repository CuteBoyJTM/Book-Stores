package com.shops.shop.Interface;

import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.Stores;
import com.shops.shop.Bean.Total;

import java.util.List;

public interface GetCartInterface {
    List<Books> getCartBooks(int user_id,int store_id);
    List<Stores> getCartStores(int user_id);
    Total getCartInfo(int user_id);
    int getCartCount(int user_id);
}
