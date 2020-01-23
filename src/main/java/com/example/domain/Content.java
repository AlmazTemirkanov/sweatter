package com.example.domain;


import javax.persistence.*;

@Entity
public class Content {
    @Id
    @SequenceGenerator(name="seq_Con", initialValue=10000, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_Con")

    private Integer id;
    private String number;
    private String type;
    private String service;
    private String provider;
    private String tariff;
    private String rounding;

    public Content(String number, String type, String service, String provider, String tariff, String rounding) {
        this.number = number;
        this.type = type;
        this.service = service;
        this.provider = provider;
        this.tariff = tariff;
        this.rounding = rounding;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getRounding() {
        return rounding;
    }

    public void setRounding(String rounding) {
        this.rounding = rounding;
    }

    public Content() {
    }

}
