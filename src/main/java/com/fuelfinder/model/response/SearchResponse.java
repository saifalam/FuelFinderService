package com.fuelfinder.model.response;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by saif on 22.11.17.
 */
@Entity
public class SearchResponse extends BaseResponse implements Serializable {
    private Station[] stations;

    public Station[] getStations() {
        return stations;
    }

    public void setStations(Station[] stations) {
        this.stations = stations;
    }
}
