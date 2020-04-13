package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddOrderDao {
    @Insert("Call addOrder(#{order_id},#{user_id})")
    void addOrder(@Param("order_id")int order_id,
                  @Param("user_id")int user_id);
    @Insert("Call addOrderContent(#{order_id},#{book_id},#{store_id},#{book_number})")
    void addOrderContent(@Param("order_id")int order_id,
                         @Param("book_id")int book_id,
                         @Param("store_id")int store_id,
                         @Param("book_number")int book_number);
    @Insert("Call cancelOrder(#{order_id})")
    void cancelOrder(@Param("order_id")int order_id);
}
