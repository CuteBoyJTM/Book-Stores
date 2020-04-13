package com.shops.shop.Interface;

import com.shops.shop.Bean.Book;
import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.BooksAll;

import java.util.List;

public interface GetBookInterface {
    List<Books> getBookListAll();
    List<Books> getBook(int id);
    List<Book> getBookList(int id);
    List<Books> getBooks(int store_id,
                         int start_subscript,
                         int pageSize);
    List<BooksAll> getBooksAll(int start_subscript,
                               int pageSize);
}
