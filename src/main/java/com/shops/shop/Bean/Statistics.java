package com.shops.shop.Bean;

import org.apache.ibatis.annotations.Param;

public class Statistics {
    private double income;
    private double expenditure;

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(double expenditure) {
        this.expenditure = expenditure;
    }
}


