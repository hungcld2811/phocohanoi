package com.phocohanoi.model;

public class BigVisit {

    private String imgUrl;
    private String name;
    private String address;
    private String type;

    public BigVisit() {
    }

    public BigVisit(String imgUrl, String name, String address, String type) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.address = address;
        this.type = type;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
