package com.shops.shop.DatabaseController;

import com.shops.shop.Bean.Statistics;
import com.shops.shop.Bean.StatisticsByAuthor;
import com.shops.shop.Bean.StatisticsByTheme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GetStatisticsDao {
    @Select("Call getStatistics(#{store_id})")
    Statistics getStatistics(@Param("store_id")int store_id);
    @Select("Call getStatisticsByAuthor(#{store_id})")
    List<StatisticsByAuthor> getStatisticsByAuthor(@Param("store_id")int store_id);
    @Select("Call getStatisticsByTheme(#{store_id})")
    List<StatisticsByTheme> getStatisticsByTheme(@Param("store_id")int store_id);
}
