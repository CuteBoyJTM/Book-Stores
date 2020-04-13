package com.shops.shop.Service;

import com.shops.shop.DatabaseController.DeleteBookDao;
import com.shops.shop.Interface.DeleteBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookService implements DeleteBookInterface {
    @Autowired
    DeleteBookDao deleteBookDao;
    @Override
    public void deleteBook(int id){
        deleteBookDao.deleteBook(id);
    };
}
