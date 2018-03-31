package com.example.myapplication.newsapp.model.gridModel;

/**
 * Created by Yara on 28-Mar-18.
 */

public class gridModel {
    String newspaper_name,newspaper_source;
    int newspaper_image;

    public gridModel(int newspaper_image, String newspaper_name, String newspaper_source) {
        this.newspaper_image = newspaper_image;
        this.newspaper_name = newspaper_name;
        this.newspaper_source = newspaper_source;
    }

    public String getNewspaper_source() {
        return newspaper_source;
    }

    public void setNewspaper_source(String newspaper_source) {
        this.newspaper_source = newspaper_source;
    }

    public int getNewspaper_image() {
        return newspaper_image;
    }

    public void setNewspaper_image(int newspaper_image) {
        this.newspaper_image = newspaper_image;
    }

    public String getNewspaper_name() {
        return newspaper_name;
    }

    public void setNewspaper_name(String newspaper_name) {
        this.newspaper_name = newspaper_name;
    }
}
