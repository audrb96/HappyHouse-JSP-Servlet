package com.ssafy.happyhouse.dto;

public class Store {
    private int storeNo;
    private String storeName;
    private String dongCode;
    private String lng;
    private String lat;

    public Store() {
    }

    public Store(int storeNo, String storeName, String dongCode, String lng, String lat) {
        this.storeNo = storeNo;
        this.storeName = storeName;
        this.dongCode = dongCode;
        this.lng = lng;
        this.lat = lat;
    }

    public int getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(int storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDongCode() {
        return dongCode;
    }

    public void setDongCode(String dongCode) {
        this.dongCode = dongCode;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeNo=" + storeNo +
                ", storeName='" + storeName + '\'' +
                ", dongCode='" + dongCode + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
