package com.example.domain;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @SequenceGenerator(name="seq", initialValue=10000, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")


//    @GeneratedValue(strategy=GenerationType.IDENTITY) SEQUENCE
//    @SequenceGenerator(name = "id", sequenceName = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO, generator="id")
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)

//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
//    @SequenceGenerator(name="generator", sequenceName="DB_SEQ_NAME")

    @Column (name="ID")
    private Integer id;

    @Column (name="area")
    private String area;

    @Column (name="district")
    private String district;

    @Column (name="region")
    private String region;

    @Column (name="selo")
    private String selo;

    @Column (name="voice")
    private String voice;

    @Column (name="WCDMA")
    private String WCDMA;

    @Column (name="LTE")
    private String LTE;

    public Integer getId(Integer id) {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setArea (String area) {
        this.area = area;
    }
    public String getArea() {
        return this.area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public Message() { }

    public Message(String area, String district, String region, String selo, String voice, String WCDMA, String LTE) {
        this.area = area;
        this.district = district;
        this.region = region;
        this.selo = selo;
        this.voice = voice;
        this.WCDMA = WCDMA;
        this.LTE = LTE;

    }
}
