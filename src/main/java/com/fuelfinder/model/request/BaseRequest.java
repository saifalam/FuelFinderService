package com.fuelfinder.model.request;

/**
 * Created by saif on 23.11.17.
 */
public class BaseRequest {
   private String id;
   private String accessToken;
   private String places[];

   //Page limit according to the network Strength
   private int limit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String[] getPlaces() {
        return places;
    }

    public void setPlaces(String[] places) {
        this.places = places;
    }
}
