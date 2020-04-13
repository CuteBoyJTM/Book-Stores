package com.shops.shop.Interface;

import com.shops.shop.Bean.Statistics;
import com.shops.shop.Bean.StatisticsByAuthor;
import com.shops.shop.Bean.StatisticsByTheme;

import java.util.List;

public interface GetStatisticsInterface {
    Statistics getStatistics(int store_id);
    List<StatisticsByAuthor> getStatisticsByAuthor(int store_id);
    List<StatisticsByTheme> getStatisticsByTheme(int store_id);
}
