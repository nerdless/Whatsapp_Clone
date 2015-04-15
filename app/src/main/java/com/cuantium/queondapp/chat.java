package com.cuantium.queondapp;


import android.media.Image;
import android.telephony.PhoneNumberUtils;

import java.util.Date;

import io.realm.RealmObject;

public class Chat extends RealmObject {
    private int chat_id;
    private Date creation_Date;
    private String owner_id;
    private String title;
    private Message last_msg;

    public Message getLast_msg() {
        return last_msg;
    }
    //private Image chat_icon;

    public void setLast_msg(Message last_msg) {
        this.last_msg = last_msg;
    }

    public int getChat_id() {
        return chat_id;
    }

    public Date getCreation_Date() {
        return creation_Date;
    }

    public String getOwner_id() {
         return owner_id;
    }

    public String getTitle() {
        return title;
    }

//    public Image getChat_icon() {
//        return chat_icon;
//    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public void setCreation_Date(Date creation_Date) {
        this.creation_Date = creation_Date;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void setChat_icon(Image chat_icon) {
//        this.chat_icon = chat_icon;
//    }
}
