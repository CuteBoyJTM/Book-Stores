package com.shops.shop.Service;

import com.shops.shop.Bean.Users;
import com.shops.shop.DatabaseController.LoginDao;
import com.shops.shop.Interface.LoginInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements LoginInterface {
    @Autowired
    LoginDao loginDao;
    @Override
    public List<Users> Login(String account, String pwd){
        return loginDao.Login(account,pwd);
    };
    @Override
    public int ChangePassword(int id, String oldPwd, String newPwd){
        return loginDao.ChangePassword(id, oldPwd, newPwd);
    };
}
