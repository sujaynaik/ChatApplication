package com.sujay.chatapplication.model;

import java.io.Serializable;

/**
 * Created by Sujay on 10-03-2017.
 */

public class Chat implements Serializable {

    private int id;
    private int chat_id;
    private String message;
    private int from_user_id;
    private int to_user_seen;
    private String created_date;

    public Chat(String message, int from_user_id, int to_user_seen) {
        this.message = message;
        this.from_user_id = from_user_id;
        this.to_user_seen = to_user_seen;
    }

    public Chat(int id, int chat_id, String message, int from_user_id, int to_user_seen, String created_date) {
        this.id = id;
        this.chat_id = chat_id;
        this.message = message;
        this.from_user_id = from_user_id;
        this.to_user_seen = to_user_seen;
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(int from_user_id) {
        this.from_user_id = from_user_id;
    }

    public int getTo_user_seen() {
        return to_user_seen;
    }

    public void setTo_user_seen(int to_user_seen) {
        this.to_user_seen = to_user_seen;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
}
