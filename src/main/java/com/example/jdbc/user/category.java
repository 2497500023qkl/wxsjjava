package com.example.jdbc.user;

import java.util.Date;

public class category {
    private long id;
    private  String name="";
    private  String property="";
    private  int sort =0;
    private  char status;
    private Date created_at;
    private Date updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
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

    public category(long id, String name, String property, int sort, char status, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.property = property;
        this.sort = sort;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public category() {
    }
}
