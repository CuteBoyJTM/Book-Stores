package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddBookDao {
    @Insert("Call addBook(#{name},#{author},#{theme},#{publisher_id},#{pages},#{proportion},#{price},#{photo})")
    void addBook(@Param("name")String name,
                 @Param("author")String author,
                 @Param("theme")String theme,
                 @Param("publisher_id")int publisher_id,
                 @Param("pages")int pages,
                 @Param("proportion")double proportion,
                 @Param("price")double price,
                 @Param("photo")String photo);
    @Insert("Call ReviseBook(#{id},#{name},#{author},#{theme},#{publisher_id},#{pages},#{proportion},#{photo})")
    void ReviseBook(@Param("id")int id,
                    @Param("name")String name,
                 @Param("author")String author,
                 @Param("theme")String theme,
                 @Param("publisher_id")int publisher_id,
                 @Param("pages")int pages,
                 @Param("proportion")double proportion,
                 @Param("photo")String photo);
    @Insert("Call deleteBook(#{id})")
    void deleteBook(@Param("id")int id);
}
