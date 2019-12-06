package com.example.domain;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name ="ID")
    private Integer id;

    @Column (name="region")
    private String region;

    @Column (name="district")
    private String district;

    @Column (name="area")
    private String area;

    @Column (name="selo")
    private String selo;

    @Column (name="voice")
    private String voice;

    @Column (name="WCDMA")
    private String WCDMA;

    @Column (name="LTE")
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

//    public Message(String text, String tag) {
//        this.text = text;
//        this.tag = tag;
//    }


    public Message(String region, String district, String area, String selo, String voice, String WCDMA, String LTE, String text, String tag) {
        this.region = region;
        this.district = district;
        this.area = area;
        this.selo = selo;
        this.voice = voice;
        this.WCDMA = WCDMA;
        this.LTE = LTE;
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

    public void delete(int id) {
    }
}
