package com.trodev.trodev.models;

public class CustomerData {
    private String name , comments, image , key;

    public CustomerData() {
    }

    public CustomerData(String name, String comments, String image, String key) {
        this.name = name;
        this.comments = comments;
        this.image = image;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
