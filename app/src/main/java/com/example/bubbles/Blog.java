package com.example.bubbles;

public class Blog {

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String day;
    private String desc;
    private String image;

    public Blog(String day, String desc, String image) {
        this.day = day;
        this.desc = desc;
        this.image = image;
    }
    public Blog(){


    }


}
