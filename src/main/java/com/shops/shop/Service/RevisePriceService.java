package com.shops.shop.Service;

import com.shops.shop.DatabaseController.RevisePriceDao;
import com.shops.shop.Interface.RevisePriceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisePriceService implements RevisePriceInterface {
    @Autowired
    RevisePriceDao revisePriceDao;
    @Override
    public void revisePrice(int book_id,
                            int store_id,
                            double price){
        revisePriceDao.revisePrice(book_id, store_id, price);
    };
}
