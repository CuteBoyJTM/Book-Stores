package com.shops.shop.Interface;

import com.shops.shop.Bean.Press;
import com.shops.shop.Bean.Store;
import com.shops.shop.Bean.Users;

import java.util.List;

public interface GetUserInterface {
    List<Press> getUser(int id);
    List<Press> getUserList(int type,int start_subscript,int pageSize);
}
