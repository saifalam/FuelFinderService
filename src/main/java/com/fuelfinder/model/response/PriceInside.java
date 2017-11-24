package com.fuelfinder.model.response;

/**
 * Created by saif on 24.11.17.
 */
public class PriceInside {
    //private String id;
    private Price[] price;

    public Price[] getPrice() {
        return price;
    }

    public void setPrice(Price[] price) {
        this.price = price;
    }
}
