package com.shops.shop.Service;

import com.shops.shop.DatabaseController.AddReceivingAddressDao;
import com.shops.shop.Interface.AddReceivingAddressInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddReceivingAddressService implements AddReceivingAddressInterface {
    @Autowired
    AddReceivingAddressDao addReceivingAddressDao;
    @Override
    public void addReceivingAddress(int user_id,
                                    String name,
                                    int phone,
                                    String address,
                                    int _default){
        addReceivingAddressDao.addReceivingAddress(user_id, name, phone, address, _default);
    };
    @Override
    public void deleteReceivingAddress(int id){
        addReceivingAddressDao.deleteReceivingAddress(id);
    };
}
