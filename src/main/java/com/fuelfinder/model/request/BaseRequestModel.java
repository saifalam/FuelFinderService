package com.fuelfinder.model.request;

/**
 * Created by saif on 23.11.17.
 */
public class BaseRequestModel {
   private String id;
   private String apiKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
