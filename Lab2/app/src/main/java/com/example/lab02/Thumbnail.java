package com.example.lab02;

public enum Thumbnail {
    Thumbnail1("Món ăn 1", R.drawable.first_thumbnail),
    Thumbnail2("Món ăn 2", R.drawable.second_thumbnail),
    Thumbnail3("Món ăn 3", R.drawable.third_thumbnail);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() { return name; }
    public int getImg() { return img; }
}