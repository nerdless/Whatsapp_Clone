package com.cuantium.queondapp;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by nerdless on 14/04/2015.
 */
public class Message extends RealmObject {
    private String content;
    private int chat_id;
    private Date creation_date;
    private int msg_status;
    private int msg_id;

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

    public void setMsg_id(int msg_id) {
        this.msg_id = msg_id;
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

    public int getMsg_id() {
        return msg_id;
    }
}
