package com.shops.shop.DatabaseController;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeleteBookDao {
    @Insert("Call deleteBook(#{id})")
    void deleteBook(@Param("id")int id);
}
