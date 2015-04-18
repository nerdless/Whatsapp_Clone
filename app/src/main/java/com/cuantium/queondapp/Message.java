package com.cuantium.queondapp;

import java.util.Calendar;
import java.util.Date;

import io.realm.RealmObject;

public class Message extends RealmObject {
    private String content;
    private int chat_id;
    private Date creation_date;
    private int msg_status;
    private String sender_id;

    public void setContent(String content) {
        this.content = content;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setMsg_status(int msg_status) {
        this.msg_status = msg_status;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getContent() {
        return content;
    }

    public int getChat_id() {
        return chat_id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public int getMsg_status() {
        return msg_status;
    }

    public String getSender_id() {
        return sender_id;
    }
}
