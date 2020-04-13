package com.shops.shop.Bean;

public class Orders {
    private int id;
    private int receiving_address_id;
    private String receiving_address;
    private String shipping_address;
    private int display;
    private int pay;
    private int courier_number;
    private double total_price;
    private int total_count;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public String getReceiving_address() {
        return receiving_address;
    }

    public void setReceiving_address(String receiving_address) {
        this.receiving_address = receiving_address;
    }

    public int getCourier_number() {
        return courier_number;
    }

    public void setCourier_number(int courier_number) {
        this.courier_number = courier_number;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getReceiving_address_id() {
        return receiving_address_id;
    }

    public void setReceiving_address_id(int receiving_address_id) {
        this.receiving_address_id = receiving_address_id;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }
}
