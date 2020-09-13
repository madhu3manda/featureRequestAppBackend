package com.mmanda.wcf.featureRequestAppBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clients {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("client")
    private int client;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    public Clients() {

    }

    public Clients(Integer id, int client,String title,String description) {
        super();
        this.id = id;
        this.client = client;
        this.title=title;
        this.description=description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }


}
