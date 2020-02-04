package com.example.domain;

import javax.persistence.*;

@Entity
public class CRMPost {

    @Id
    @SequenceGenerator(name="seq_CrmP", initialValue=10000, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_CrmP")

    private Integer id;
    private String sr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public CRMPost(String sr) {
        this.sr = sr;
    }

    public CRMPost() {
    }
}
