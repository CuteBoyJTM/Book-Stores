package com.shops.shop.Service;

import com.shops.shop.DatabaseController.RegisterDao;
import com.shops.shop.Interface.RegisterInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterInterface {
    @Autowired
    RegisterDao registerDao;
    @Override
    public int checkAccount(String account){
        return registerDao.checkAccount(account);
    };
    @Override
    public int Register(int type, String account, String pwd, String name, int phone, String address, long bank_account, String email){
        return registerDao.Register(type, account, pwd, name, phone, address, bank_account, email);
    };
}
