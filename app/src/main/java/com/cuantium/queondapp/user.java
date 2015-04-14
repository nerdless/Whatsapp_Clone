package com.cuantium.queondapp;

import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by nerdless on 07/04/2015.
 */
public class User extends RealmObject
{
    private String name;
    private String last_name;
    private String user_name;
    private String user_status;
    private String phone_number;
    private Date last_time_online;
    private boolean is_online;

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_status() {
        return user_status;
    }

    public String getPhone_number() {  return phone_number;   }

    public Date getLast_time_online() {
        return last_time_online;
    }

    public boolean isIs_online() {
        return is_online;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public void setPhone_number(String phone_number) {this.phone_number = phone_number; }

    public void setLast_time_online(Date last_time_online) {
        this.last_time_online = last_time_online;
    }

    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }
}
