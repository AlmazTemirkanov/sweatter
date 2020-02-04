package com.example.domain;

import javax.persistence.*;

@Entity
public class CRM {
    @Id
    @SequenceGenerator(name="seq_Crm", initialValue=10000, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_Crm")

    private Integer id;
    private String sr;

    public CRM(String sr) {
        this.sr = sr;
    }

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


    public CRM() {}
}
