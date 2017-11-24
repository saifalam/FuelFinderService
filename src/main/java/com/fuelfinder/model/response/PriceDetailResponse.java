package com.fuelfinder.model.response;

/**
 * Created by saif on 24.11.17.
 */
public class PriceDetailResponse extends BaseResponse {

    private PriceDetail prices;

    public PriceDetail getPrices() {
        return prices;
    }

    public void setPrices(PriceDetail prices) {
        this.prices = prices;
    }
}
