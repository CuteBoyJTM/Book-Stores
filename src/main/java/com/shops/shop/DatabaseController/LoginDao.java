package com.shops.shop.DatabaseController;

import com.shops.shop.Bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginDao {
    @Select("Call Login(#{account},#{pwd})")
    List<Users> Login(@Param("account")String account,
                      @Param("pwd")String pwd);
    @Select("Call ChangePassword(#{id},#{oldPwd},#{newPwd})")
    int ChangePassword(@Param("id")int id,
                       @Param("oldPwd")String oldPwd,
                       @Param("newPwd")String newPwd);
}
