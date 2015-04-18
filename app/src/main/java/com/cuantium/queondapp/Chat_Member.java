package com.cuantium.queondapp;

import java.util.Date;

import io.realm.RealmObject;

public class Chat_Member extends RealmObject
{
    private int chat_id;
    private String user_id;
    private Date user_added_date;
    private String user_added_by;
    private boolean group_chat; //if its true, it is a group conversation, if it is false is an individual conversation

    public void setGroup_chat(boolean group_chat) {
        this.group_chat = group_chat;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_added_date(Date user_added_date) {
        this.user_added_date = user_added_date;
    }

    public void setUser_added_by(String user_added_by) {
        this.user_added_by = user_added_by;
    }

    public boolean isGroup_chat() {
        return group_chat;
    }

    public int getChat_id() {
        return chat_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public Date getUser_added_date() {
        return user_added_date;
    }

    public String getUser_added_by() {
        return user_added_by;
    }
}
