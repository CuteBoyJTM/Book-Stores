package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RevisePriceDao {
    @Insert("Call revisePrice(#{book_id},#{store_id},#{price})")
    void revisePrice(@Param("book_id") int book_id,
                     @Param("store_id")int store_id,
                     @Param("price")double price);
}
