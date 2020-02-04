package com.example.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Pull {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer number;
    private String topic;
    private String date_on;
    private String date_off;
    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDate_on() {
        return date_on;
    }

    public void setDate_on(String date_on) {
        this.date_on = date_on;
    }

    public String getDate_off() {
        return date_off;
    }

    public void setDate_off(String date_off) {
        this.date_off = date_off;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Pull(Integer number, String topic, String date_on, String date_off, String comments) {
        this.number = number;
        this.topic = topic;
        this.date_on = date_on;
        this.date_off = date_off;
        this.comments = comments;
    }

    public Pull() { }
}
