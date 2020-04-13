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

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class StatisticsController {
    @Autowired
    GetStatisticsInterface getStatisticsInterface;
    class ReturnStatistics{
        private Statistics statistics;
        private String[] author;
        private String[] theme;
        private int[] authorValue;
        private int[] themeValue;

        public String[] getAuthor() {
            return author;
        }

        public void setAuthor(String[] author) {
            this.author = author;
        }

        public String[] getTheme() {
            return theme;
        }

        public void setTheme(String[] theme) {
            this.theme = theme;
        }

        public int[] getAuthorValue() {
            return authorValue;
        }

        public void setAuthorValue(int[] authorValue) {
            this.authorValue = authorValue;
        }

        public int[] getThemeValue() {
            return themeValue;
        }

        public void setThemeValue(int[] themeValue) {
            this.themeValue = themeValue;
        }

        public Statistics getStatistics() {
            return statistics;
        }

        public void setStatistics(Statistics statistics) {
            this.statistics = statistics;
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
            List<StatisticsByAuthor> statisticsByAuthors = new ArrayList<>(getStatisticsInterface.getStatisticsByAuthor(store_id));
            List<StatisticsByTheme> statisticsByThemes = new ArrayList<>(getStatisticsInterface.getStatisticsByTheme(store_id));
            String[] author = new String[statisticsByAuthors.size()];
            String[] theme= new String[statisticsByThemes.size()];
            int[] authorValue= new int[statisticsByAuthors.size()];;
            int[] themeValue= new int[statisticsByThemes.size()];;
            for(int i = 0;i<statisticsByAuthors.size();i++){
                author[i]=statisticsByAuthors.get(i).getAuthor();
                authorValue[i]=statisticsByAuthors.get(i).getVolume();
            }
            for(int i = 0;i<statisticsByThemes.size();i++){
                theme[i]=statisticsByThemes.get(i).getTheme();
                themeValue[i]=statisticsByThemes.get(i).getVolume();
            }
            returnStatistics.setAuthor(author);
            returnStatistics.setAuthorValue(authorValue);
            returnStatistics.setTheme(theme);
            returnStatistics.setThemeValue(themeValue);
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
