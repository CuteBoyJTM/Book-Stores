package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExportBookDao {
    @Insert("Call exportBook(#{book_id},#{store_id})")
    void exportBook(@Param("book_id")int book_id,
                    @Param("store_id")int store_id);
    @Select("Call importBook(#{book_id},#{store_id},#{number},#{price})")
    int importBook(@Param("book_id")int book_id,
                    @Param("store_id")int store_id,
                   @Param("number")int number,
                   @Param("price")double price);
}
