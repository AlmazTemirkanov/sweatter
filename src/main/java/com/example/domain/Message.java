package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

//    private String region;
//    private String district;
//    private String area;
//    private String selo;
//    private String voice;
//    private String WCDMA;
//    private String LTE;





    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String text;
    private String tag;
    public Message(){ }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }



    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }
}
