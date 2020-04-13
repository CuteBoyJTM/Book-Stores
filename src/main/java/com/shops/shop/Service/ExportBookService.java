package com.shops.shop.Service;

import com.shops.shop.DatabaseController.ExportBookDao;
import com.shops.shop.Interface.ExportBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportBookService implements ExportBookInterface {
    @Autowired
    ExportBookDao exportBookDao;
    @Override
    public void exportBook(int book_id,int store_id){
        exportBookDao.exportBook(book_id, store_id);
    };
    @Override
    public int importBook(int book_id,
                          int store_id,
                          int number,
                          double price){
        return exportBookDao.importBook(book_id, store_id, number, price);
    };
}
