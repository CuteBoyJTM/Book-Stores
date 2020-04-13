package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddToCartDao {
    @Insert("Call addToCart(#{user_id},#{book_id},#{store_id},#{number})")
    void addToCart(@Param("user_id")int user_id,
                   @Param("book_id")int book_id,
                   @Param("store_id")int store_id,
                   @Param("number")int number);
    @Insert("Call deleteFromCart(#{user_id},#{book_id},#{store_id})")
    void deleteFromCart(@Param("user_id")int user_id,
                   @Param("book_id")int book_id,
                   @Param("store_id")int store_id);
    @Select("Call updateChecked(#{user_id},#{book_id},#{store_id},#{checked})")
    double updateChecked(@Param("user_id")int user_id,
                   @Param("book_id")int book_id,
                   @Param("store_id")int store_id,
                   @Param("checked")int checked);
}
