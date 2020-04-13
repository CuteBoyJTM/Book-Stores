package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PayForOrderDao {
    @Insert("Call payForOrder(#{order_id})")
    void payForOrder(
                     @Param("order_id")int order_id);
}
