package com.example.domain;

import javax.persistence.*;

@Entity
public class Privet {

    @Id
    @SequenceGenerator(name="seq_Priv", initialValue=10000, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_Priv")
//    @SequenceGenerator(name="seq", initialValue=1, allocationSize=10000)
//    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    private Integer id;
    private Integer code;
    private String title;
    private String author;
    private String genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Privet() { }

    public Privet(Integer code, String title, String author, String genre) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
