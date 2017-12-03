package com.fuelfinder.model.response;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by saif on 22.11.17.
 */
@Entity
public class Station extends Price implements Serializable {
    @Id
    private String id;
    private String name;
    private String brand;
    private String distance;
    private String isOpen;
    private String place;
    private String street;
    private String houseNumber;
    private String postCode;
    private float lat;
    private float lng;
    private OpeningTime[] openingTimes;
    private String wholeDay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public OpeningTime[] getOpeningTimes() {
        return openingTimes;
    }

    public void setOpeningTimes(OpeningTime[] openingTimes) {
        this.openingTimes = openingTimes;
    }

    public String getWholeDay() {
        return wholeDay;
    }

    public void setWholeDay(String wholeDay) {
        this.wholeDay = wholeDay;
    }
}
