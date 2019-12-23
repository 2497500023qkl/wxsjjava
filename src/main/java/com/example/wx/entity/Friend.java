package com.example.wx.entity;

import java.util.Date;

public class Friend {
    private long id;
    private long userId;
    private long friendId;
    private Date createdAt;
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFriendId() {
        return friendId;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Friend(long id, long userId, long friendId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userId = userId;
        this.friendId = friendId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Friend() {
    }
}
