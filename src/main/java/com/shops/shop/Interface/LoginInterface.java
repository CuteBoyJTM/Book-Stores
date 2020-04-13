package com.shops.shop.Interface;

import com.shops.shop.Bean.Users;

import java.util.List;

public interface LoginInterface {
    List<Users> Login(String account, String pwd);
    int ChangePassword(int id, String oldPwd, String newPwd);
}
