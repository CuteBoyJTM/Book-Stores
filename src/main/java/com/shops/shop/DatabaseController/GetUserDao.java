package com.shops.shop.DatabaseController;

import com.shops.shop.Bean.Press;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GetUserDao {
    @Select("Call getUser(#{id})")
    List<Press> getUser(@Param("id")int id);
    @Select("Call getUserList(#{type},#{start_subscript},#{pageSize})")
    List<Press> getUserList(@Param("type")int type,
                            @Param("start_subscript")int start_subscript,
                            @Param("pageSize")int pageSize);

}
