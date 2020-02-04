package com.example.domain;

import javax.persistence.*;

@Entity
public class SMS {

    @Id
    @SequenceGenerator(name="seq_Sms", initialValue=10000, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_Sms")

    private Integer id;
    private String date;
    private String topic;
    private String initiator;
    private String text_topic;
    private String pull;
    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getText() {
        return text_topic;
    }

    public void setText(String text) {
        this.text_topic = text;
    }

    public String getPull() {
        return pull;
    }

    public void setPull(String pull) {
        this.pull = pull;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public SMS(String date, String topic, String initiator, String text, String pull, String comments) {
        this.date = date;
        this.topic = topic;
        this.initiator = initiator;
        this.text_topic = text;
        this.pull = pull;
        this.comments = comments;
    }

    public SMS() { }
}
