package com.shops.shop.Service;

import com.shops.shop.DatabaseController.AddBookDao;
import com.shops.shop.Interface.AddBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBookService implements AddBookInterface {
    @Autowired
    AddBookDao addBookDao;
    @Override
    public void addBook(String name,String author,String theme,int publisher_id,int pages,double proportion,double price,String photo){
        addBookDao.addBook(name, author, theme, publisher_id, pages, proportion,price,photo);
    };
    @Override
    public void deleteBook(int id){
        addBookDao.deleteBook(id);
    };
    @Override
    public void ReviseBook(int id,String name,String author,String theme,int publisher_id,int pages,double proportion,String photo){
        addBookDao.ReviseBook(id, name, author, theme, publisher_id, pages, proportion, photo);
    };
}
