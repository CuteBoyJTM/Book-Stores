package com.shops.shop.DatabaseController;

import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.OrderList;
import com.shops.shop.Bean.Orders;
import com.shops.shop.Bean.Stores;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GetOrderDao {
    @Select("Call getOrderBooks(#{order_id},#{store_id})")
    List<Books> getOrderBooks(@Param("order_id")int order_id,
                             @Param("store_id")int store_id);
    @Select("Call getOrderStores(#{order_id})")
    List<Stores> getOrderStores(@Param("order_id")int order_id);
    @Select("Call getOrderFirstBook(#{order_id})")
    List<Books> getOrderFirstBook(@Param("order_id")int order_id);
    @Select("Call getOrderPaid(#{user_id},#{start_subscript},#{pageSize})")
    List<OrderList> getOrderPaid(@Param("user_id")int user_id,
                                 @Param("start_subscript")int start_subscript,
                                 @Param("pageSize")int pageSize);
    @Select("Call getOrderToBePaid(#{user_id},#{start_subscript},#{pageSize})")
    List<OrderList> getOrderToBePaid(@Param("user_id")int user_id,
                                 @Param("start_subscript")int start_subscript,
                                 @Param("pageSize")int pageSize);
    @Select("Call getOrder(#{order_id})")
    List<Orders> getOrder(@Param("order_id")int order_id);
}
