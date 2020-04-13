package com.shops.shop.Service;

import com.shops.shop.Bean.ReceivingAddress;
import com.shops.shop.DatabaseController.GetReceivingAddressDao;
import com.shops.shop.Interface.GetReceivingAddressInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetReceivingAddressService implements GetReceivingAddressInterface {
    @Autowired
    GetReceivingAddressDao getReceivingAddressDao;
    @Override
    public List<ReceivingAddress> getReceivingAddress(int user_id,
                                                      int start_subscript,
                                                      int pageSize){
        return getReceivingAddressDao.getReceivingAddress(user_id, start_subscript, pageSize);
    };
    @Override
    public List<ReceivingAddress> getReceivingAddressById(int id){
        return getReceivingAddressDao.getReceivingAddressById(id);
    };
}
