package com.mmanda.wcf.featureRequestAppBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientsEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "client")
    private int client;

    public ClientsEntity() {
    }

    public ClientsEntity(Integer id) {
        this.id = id;
    }

    public ClientsEntity(Integer id, int client) {
        this.id = id;
        this.client = client;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClient() {
        return this.client;
    }

    public void setClient(int client) {
        this.client = client;
    }
}
