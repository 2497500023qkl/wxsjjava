package com.example.wx.entity;

import java.util.Date;

public class NewChat {
    private long id;
    private String nickname;
    private String avatar;
    private String content;
    private String username;
    private Date createdAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public NewChat(String nickname, String avatar, String content, Date createdAt ,long id,String username) {
        this.nickname = nickname;
        this.avatar = avatar;
        this.content = content;
        this.createdAt = createdAt;
        this.id=id;
        this.username=username;
    }

    public NewChat() {
    }
}
