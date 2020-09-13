package com.mmanda.wcf.featureRequestAppBackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class FailureResponse {

    @JsonProperty("status")
    private HttpStatus status;

    @JsonCreator
    public FailureResponse(HttpStatus status){

    }
}
