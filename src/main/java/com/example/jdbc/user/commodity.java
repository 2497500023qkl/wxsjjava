package com.example.jdbc.user;

import java.util.Date;

public class commodity {
    private long id;
    private long category_id;
    private String name;
    private int sale_num;
    private String content;
    private int sort;
    private char status;
    private Date created_at;
    private Date updated_at;
    private String category_name;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSale_num() {
        return sale_num;
    }

    public void setSale_num(int sale_num) {
        this.sale_num = sale_num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public commodity(long id, long category_id, String name, int sale_num, String content, int sort, char status ,Date created_at , Date updated_at , String category_name) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.sale_num = sale_num;
        this.content = content;
        this.sort = sort;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.category_name = category_name;
    }

    public commodity() {
    }
}
