package com.fuelfinder.model.response;

/**
 * Created by saif on 24.11.17.
 */
public class Price {

    // Station ID
    private String id;

    //"status": "open", - gas station is open
    //"status": "closed" - gas station is closed
    //"status": "no prices" - no petrol station prices available
    private String status;
    private String e5;
    private String e10;
    private String diesel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getE5() {
        return e5;
    }

    public void setE5(String e5) {
        this.e5 = e5;
    }

    public String getE10() {
        return e10;
    }

    public void setE10(String e10) {
        this.e10 = e10;
    }

    public String getDiesel() {
        return diesel;
    }

    public void setDiesel(String diesel) {
        this.diesel = diesel;
    }
}
