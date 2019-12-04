package com.example.jdbc.user;

import java.util.Date;

public class sku {
    private long id;
    private long product_id;
    private double original_price;
    private  double price;
    private String attr1;
    private String attr2;
    private String attr3;
    private long quantity;
    private int sort;
    private char status;
    private Date created_at;
    private Date updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public sku(long id, long product_id, double original_price, double price, String attr1, String attr2, String attr3, long quantity, int sort, char status, Date created_at, Date updated_at) {
        this.id = id;
        this.product_id = product_id;
        this.original_price = original_price;
        this.price = price;
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.attr3 = attr3;
        this.quantity = quantity;
        this.sort = sort;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public sku() {
    }
}
