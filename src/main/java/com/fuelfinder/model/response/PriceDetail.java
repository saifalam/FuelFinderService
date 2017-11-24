package com.fuelfinder.model.response;

/**
 * Created by saif on 24.11.17.
 */
public class PriceDetail {
    private PriceInside[] priceInsides;

    public PriceInside[] getPriceInsides() {
        return priceInsides;
    }

    public void setPriceInsides(PriceInside[] priceInsides) {
        this.priceInsides = priceInsides;
    }
}
