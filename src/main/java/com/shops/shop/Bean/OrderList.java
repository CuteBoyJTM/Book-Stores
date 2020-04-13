package com.shops.shop.Bean;

public class OrderList {
    private int id;
    private double total_price;
    private int courier_number;
    private int total_count;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getCourier_number() {
        return courier_number;
    }

    public void setCourier_number(int courier_number) {
        this.courier_number = courier_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
