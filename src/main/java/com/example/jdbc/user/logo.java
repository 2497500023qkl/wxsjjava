package com.example.jdbc.user;

import java.util.Date;

public class logo {
    private long type_id;
    private long id;
    private long sort;
    private String title;
    private String picture;
    private long link_type;
    private String link_target;
    private char status;
    private Date created_at;
    private Date updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getLink_type() {
        return link_type;
    }

    public void setLink_type(long link_type) {
        this.link_type = link_type;
    }

    public String getLink_target() {
        return link_target;
    }

    public void setLink_target(String link_target) {
        this.link_target = link_target;
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
}
