package com.spectraapps.tohfa.bottomtabscreens.home;

/**
 * Created by MahmoudAyman on 13/01/2018.
 */

public class HomeData {

    private int image;
    private String text;

    public HomeData() {
    }

    public HomeData(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
