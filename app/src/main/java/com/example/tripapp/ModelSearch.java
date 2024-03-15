package com.example.tripapp;

public class ModelSearch {

    int image;
    String title;
    String sutitle;

    public ModelSearch() {}

    public ModelSearch(int image, String title, String sutitle) {
        this.image = image;
        this.title = title;
        this.sutitle = sutitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSutitle() {
        return sutitle;
    }

    public void setSutitle(String sutitle) {
        this.sutitle = sutitle;
    }
}
