package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterDao {
    @Select("Call checkAccount(#{account})")
    int checkAccount(@Param("account")String account);
    @Select("Call Register(#{type},#{account},#{pwd},#{name},#{phone},#{address},#{bank_account},#{email})")
    int Register(@Param("type")int type,
                 @Param("account")String account,
                 @Param("pwd")String pwd,
                 @Param("name")String name,
                 @Param("phone")int phone,
                 @Param("address")String address,
                 @Param("bank_account")long bank_account,
                 @Param("email")String email);
}
