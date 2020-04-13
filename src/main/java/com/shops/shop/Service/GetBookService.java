package com.shops.shop.Service;

import com.shops.shop.Bean.Book;
import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.BooksAll;
import com.shops.shop.DatabaseController.GetBookDao;
import com.shops.shop.Interface.GetBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBookService implements GetBookInterface {
    @Autowired
    GetBookDao getBookDao;
    @Override
    public  List<Books> getBookListAll(){
        return getBookDao.getBookListAll();
    };
    @Override
    public List<Books> getBook(int id){
        return getBookDao.getBook(id);
    };
    @Override
    public List<Book> getBookList(int id){
        return getBookDao.getBookList(id);
    };
    @Override
    public List<Books> getBooks(int store_id,
                                  int start_subscript,
                                  int pageSize){
        return getBookDao.getBooks(store_id, start_subscript, pageSize);
    };
    @Override
    public List<BooksAll> getBooksAll(int start_subscript,
                                      int pageSize){
        return getBookDao.getBooksAll(start_subscript, pageSize);
    };
}
