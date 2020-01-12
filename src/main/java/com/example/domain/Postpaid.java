package com.example.domain;

import javax.persistence.*;

@Entity
public class Postpaid {

    @Id
    @SequenceGenerator(name="seq_Pos", initialValue=10000, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_Pos")
//    @SequenceGenerator(name="seq", initialValue=1, allocationSize=10000)
//    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")


    private Integer id;
    private  String tariff_zone;
    private  String country;
    private  String company;
    private  String name_network;
    private  String mnc;
    private  String pmn;
    private  String network;

    public Postpaid() { }

    public Postpaid(String tariff_zone, String country, String company, String name_network, String mnc, String pmn, String network) {
        this.tariff_zone = tariff_zone;
        this.country = country;
        this.company = company;
        this.name_network = name_network;
        this.mnc = mnc;
        this.pmn = pmn;
        this.network = network;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTariff_zone() {
        return tariff_zone;
    }

    public void setTariff_zone(String tariff_zone) {
        this.tariff_zone = tariff_zone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName_network() {
        return name_network;
    }

    public void setName_network(String name_network) {
        this.name_network = name_network;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getPmn() {
        return pmn;
    }

    public void setPmn(String pmn) {
        this.pmn = pmn;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}
