package com.fuelfinder.model.response;

import java.util.Map;

/**
 * Created by saif on 24.11.17.
 */
public class PriceDetailResponse extends BaseResponse {

    private Map<String, Price> prices;

    public Map<String, Price> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Price> prices) {
        this.prices = prices;
    }
}
