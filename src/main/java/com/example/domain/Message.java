package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String region;
    private String district;
    private String area;
    private String selo;
    private String voice;
    private String WCDMA;
    private String LTE;


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSelo() {
        return selo;
    }

    public void setSelo(String selo) {
        this.selo = selo;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getWCDMA() {
        return WCDMA;
    }

    public void setWCDMA(String WCDMA) {
        this.WCDMA = WCDMA;
    }

    public String getLTE() {
        return LTE;
    }

    public void setLTE(String LTE) {
        this.LTE = LTE;
    }





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
