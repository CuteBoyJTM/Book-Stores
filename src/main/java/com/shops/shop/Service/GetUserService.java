package com.shops.shop.Service;

import com.shops.shop.Bean.Press;
import com.shops.shop.Bean.Store;
import com.shops.shop.Bean.Users;
import com.shops.shop.DatabaseController.GetUserDao;
import com.shops.shop.Interface.GetUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserService implements GetUserInterface{
    @Autowired
    GetUserDao getUserDao;

    @Override
    public List<Press> getUser(int id){
        return getUserDao.getUser(id);
    }
    @Override
    public List<Press> getUserList(int type,int start_subscript,int pageSize){
        return getUserDao.getUserList(type, start_subscript, pageSize);
    }

}
