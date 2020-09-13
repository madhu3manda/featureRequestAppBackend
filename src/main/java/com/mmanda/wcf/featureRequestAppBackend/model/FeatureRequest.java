package com.mmanda.wcf.featureRequestAppBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class FeatureRequest {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("client")
    private String client;

    @JsonProperty("priority")
    private int priority;

    @JsonProperty("targetDate")
    private Timestamp targetDate;

    @JsonProperty("parea")
    private String productArea;

    public FeatureRequest() {}

    public FeatureRequest(Integer id, String title, String description, String client, int priority, Timestamp targetDate,String productArea) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.client=client;
        this.priority = priority;
        this.targetDate = targetDate;
        this.productArea=productArea;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getClient() {
        return client;
    }

    public int getPriority() {
        return priority;
    }

    public Timestamp getTargetDate() {
        return targetDate;
    }

    @JsonProperty("parea")
    public String getProductArea() {
        return productArea;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
