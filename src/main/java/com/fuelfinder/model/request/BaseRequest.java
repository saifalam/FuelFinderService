package com.fuelfinder.model.request;

/**
 * Created by saif on 23.11.17.
 */
public class BaseRequest {
   private String id;
   private String excessToken;
   private String places[];

   //Page limit according to the network Strength
   private int limit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExcessToken() {
        return excessToken;
    }

    public void setExcessToken(String excessToken) {
        this.excessToken = excessToken;
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
