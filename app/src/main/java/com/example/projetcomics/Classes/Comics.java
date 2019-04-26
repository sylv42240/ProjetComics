package com.example.projetcomics.Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Comics implements Serializable {
    private String title;
    private String description;
    private String diamondCode;
    private String url;
    private String saleDate;
    private String price;
    private String image;
    private ArrayList<Creator> creators;

    public Comics(String title, String description, String diamondCode, String url, String saleDate, String price, String image, ArrayList<Creator> cretors) {
        this.title = title;
        this.description = description;
        this.diamondCode = diamondCode;
        this.url = url;
        this.saleDate = saleDate;
        this.price = price;
        this.image = image;
        this.creators = cretors;
    }

    public ArrayList<Creator> getCretors() {
        return creators;
    }

    public void setCretors(ArrayList<Creator> cretors) {
        this.creators = cretors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Comics{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", diamondCode='" + diamondCode + '\'' +
                ", url='" + url + '\'' +
                ", saleDate='" + saleDate + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                ", cretors=" + creators +
                '}';
    }
}
