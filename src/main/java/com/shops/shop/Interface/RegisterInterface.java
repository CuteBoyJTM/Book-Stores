package com.shops.shop.Interface;

public interface RegisterInterface {
    int Register(int type, String account, String pwd, String name, int phone, String address, int bank_account, String email);
    int checkAccount(String account);
}
