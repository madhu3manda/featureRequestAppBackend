package com.mmanda.wcf.featureRequestAppBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class FeatureRequestEntity implements Comparable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="priority")
    private Integer priority;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="client")
    private String client;

    @Column(name="targetDate")
    private Timestamp targetDate;

    @JsonProperty("productArea")
    private String productArea;

    public FeatureRequestEntity() {
    }

    public FeatureRequestEntity(Integer id, Integer priority,
                               String title, String description, String client, Timestamp targetDate,String productArea) {
        this.id = id;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.client=client;
        this.targetDate = targetDate;
        this.productArea=productArea;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTargetDate() {
        return this.targetDate;
    }

    public void setTargetDate(Timestamp targetDate) {
        this.targetDate = targetDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {

        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getProductArea() {
        return productArea;
    }

    @Override
    public int compareTo(String o) {
        // TODO Auto-generated method stub
        return this.client.compareTo(o);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeatureRequestEntity{");
        sb.append("id=").append(id);
        sb.append(", priority=").append(priority);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", client=").append(client);
        sb.append(", targetDate=").append(targetDate);
        sb.append(", productArea=").append(productArea);
        sb.append('}');
        return sb.toString();
    }
}
