package com.fuelfinder.model.response;

/**
 * Created by saif on 22.11.17.
 */
public class SearchResponse extends BaseResponse {
    private Station[] stations;

    public Station[] getStations() {
        return stations;
    }

    public void setStations(Station[] stations) {
        this.stations = stations;
    }
}
