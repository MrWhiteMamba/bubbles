package com.example.bubbles;

public class Blog {

    public String getDay() {
        return day;
    }
    public Integer getId() {
        return id;
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
    private Integer id;

    public Blog(String day, String desc, String image,Integer id) {
        this.day = day;
        this.desc = desc;
        this.image = image;
        this.id = id;
    }
    public Blog(){


    }


}
