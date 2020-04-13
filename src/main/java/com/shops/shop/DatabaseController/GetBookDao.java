package com.shops.shop.DatabaseController;

import com.shops.shop.Bean.Book;
import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.BooksAll;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface GetBookDao {
    @Select("Call getBookListAll()")
    List<Books> getBookListAll();
    @Select("Call getBook(#{id})")
    List<Books> getBook(@Param("id")int id);
    @Select("Call getBookList(#{id})")
    List<Book> getBookList(@Param("id")int id);
    @Select("Call getBooks(#{store_id},#{start_subscript},#{pageSize})")
    List<Books> getBooks(@Param("store_id")int store_id,
                         @Param("start_subscript")int start_subscript,
                         @Param("pageSize")int pageSize);
    @Select("Call getBooksAll(#{start_subscript},#{pageSize})")
    List<BooksAll> getBooksAll(@Param("start_subscript")int start_subscript,
                               @Param("pageSize")int pageSize);

}
