package com.shops.shop.Bean;


public class ReceivingAddress {
    private int id;
    private String  name;
    private int phone;
    private String address;
    private int _default;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int get_default() {
        return _default;
    }

    public void set_default(int _default) {
        this._default = _default;
    }
}
