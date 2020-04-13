package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddReceivingAddressDao {
    @Insert("Call addReceivingAddress(#{user_id},#{name},#{phone},#{address},#{_default})")
    void addReceivingAddress(@Param("user_id")int user_id,
                             @Param("name")String name,
                             @Param("phone")int phone,
                             @Param("address")String address,
                             @Param("_default")int _default);
    @Insert("Call deleteReceivingAddress(#{id})")
    void deleteReceivingAddress(@Param("id")int id);
    @Insert("Call setDefault(#{user_id},#{receiving_address_id})")
    void setDefault(@Param("user_id")int user_id,
                    @Param("receiving_address_id")int receiving_address_id);
}
