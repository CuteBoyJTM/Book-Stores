package com.shops.shop.Controller;

import com.shops.shop.Bean.Result;
import com.shops.shop.Bean.Statistics;
import com.shops.shop.Bean.StatisticsByAuthor;
import com.shops.shop.Bean.StatisticsByTheme;
import com.shops.shop.Interface.GetStatisticsInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class StatisticsController {
    @Autowired
    GetStatisticsInterface getStatisticsInterface;
    class ReturnStatistics{
        private Statistics statistics;
        private List<StatisticsByAuthor> statisticsByAuthor;
        private List<StatisticsByTheme> statisticsByTheme;

        public Statistics getStatistics() {
            return statistics;
        }

        public void setStatistics(Statistics statistics) {
            this.statistics = statistics;
        }

        public List<StatisticsByAuthor> getStatisticsByAuthor() {
            return statisticsByAuthor;
        }

        public void setStatisticsByAuthor(List<StatisticsByAuthor> statisticsByAuthor) {
            this.statisticsByAuthor = statisticsByAuthor;
        }

        public List<StatisticsByTheme> getStatisticsByTheme() {
            return statisticsByTheme;
        }

        public void setStatisticsByTheme(List<StatisticsByTheme> statisticsByTheme) {
            this.statisticsByTheme = statisticsByTheme;
        }
    }
    @RequestMapping(value = "/getStatistics", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getStatistics(
            @Param("store_id")int store_id
    ){
        Result result = new Result();
        try{
            ReturnStatistics returnStatistics = new ReturnStatistics();
            returnStatistics.setStatistics(getStatisticsInterface.getStatistics(store_id));
            returnStatistics.setStatisticsByAuthor(getStatisticsInterface.getStatisticsByAuthor(store_id));
            returnStatistics.setStatisticsByTheme(getStatisticsInterface.getStatisticsByTheme(store_id));
            result.setStatus(100);
            result.setMsg("获取成功.");
            result.setValue(returnStatistics);
            log.info("获取成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    };
}
