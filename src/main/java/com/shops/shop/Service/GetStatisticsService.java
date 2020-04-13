package com.shops.shop.Service;

import com.shops.shop.Bean.Statistics;
import com.shops.shop.Bean.StatisticsByAuthor;
import com.shops.shop.Bean.StatisticsByTheme;
import com.shops.shop.DatabaseController.GetStatisticsDao;
import com.shops.shop.Interface.GetStatisticsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatisticsService implements GetStatisticsInterface {
    @Autowired
    GetStatisticsDao getStatisticsDao;
    @Override
    public Statistics getStatistics(int store_id){
        return getStatisticsDao.getStatistics(store_id);
    };
    @Override
    public List<StatisticsByAuthor> getStatisticsByAuthor(int store_id){
        return getStatisticsDao.getStatisticsByAuthor(store_id);
    };
    @Override
    public List<StatisticsByTheme> getStatisticsByTheme(int store_id){
        return getStatisticsDao.getStatisticsByTheme(store_id);
    };
}
