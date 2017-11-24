package com.fuelfinder.model.request;

import java.util.List;

/**
 * Created by saif on 24.11.17.
 */
public class PriceRequest extends BaseRequest {

    private List<String> idList;

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }
}
