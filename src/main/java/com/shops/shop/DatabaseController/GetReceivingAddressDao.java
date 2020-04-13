package com.shops.shop.DatabaseController;

import com.shops.shop.Bean.ReceivingAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GetReceivingAddressDao {
    @Select("Call getReceivingAddress(#{user_id},#{start_subscript},#{pageSize})")
    List<ReceivingAddress> getReceivingAddress(@Param("user_id")int user_id,
                                               @Param("start_subscript")int start_subscript,
                                               @Param("pageSize")int pageSize);
    @Select("Call getReceivingAddressById(#{id})")
    List<ReceivingAddress> getReceivingAddressById(@Param("id")int id);
}
