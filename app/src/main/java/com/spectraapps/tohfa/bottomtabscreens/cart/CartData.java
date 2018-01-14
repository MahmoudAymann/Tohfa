package com.spectraapps.tohfa.bottomtabscreens.cart;

/**
 * Created by MahmoudAyman on 04/01/2018.
 */

public class CartData {
    private String name;
    private String name2;
    private String image;

    public CartData() {
    }

    public CartData(String name, String name2, String image) {
        this.name = name;
        this.name2 = name2;
        this.image = image;
    }

    public CartData(String name, String name2) {
        this.name = name;
        this.name2 = name2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
