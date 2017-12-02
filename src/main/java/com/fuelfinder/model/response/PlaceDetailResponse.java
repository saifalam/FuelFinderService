package com.fuelfinder.model.response;

/**
 * Created by saif on 23.11.17.
 */
public class PlaceDetailResponse extends BaseResponse {
    private Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
