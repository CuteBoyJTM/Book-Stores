package com.shops.shop.Service;

import com.shops.shop.DatabaseController.PayForOrderDao;
import com.shops.shop.Interface.PayForOrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayForOrderService implements PayForOrderInterface {
    @Autowired
    PayForOrderDao payForOrderDao;
    @Override
    public void payForOrder(
                            int order_id){
        payForOrderDao.payForOrder( order_id);
    };
}
