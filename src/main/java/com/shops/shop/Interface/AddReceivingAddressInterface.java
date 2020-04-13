package com.shops.shop.Interface;

public interface AddReceivingAddressInterface {
    void addReceivingAddress(int user_id,
                             String name,
                             int phone,
                             String address,
                             int _default);
    void deleteReceivingAddress(int id);
}
