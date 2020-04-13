package com.shops.shop.DatabaseController;

import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.Stores;
import com.shops.shop.Bean.Total;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
@Repository
public interface GetCartDao {
    @Select("Call getCartBooks(#{user_id},#{store_id})")
    List<Books> getCartBooks(@Param("user_id")int user_id,
                             @Param("store_id")int store_id);
    @Select("Call getCartStores(#{user_id})")
    List<Stores> getCartStores(@Param("user_id")int user_id);
    @Select("Call getCartInfo(#{user_id})")
    Total getCartInfo(@Param("user_id")int user_id);
}
