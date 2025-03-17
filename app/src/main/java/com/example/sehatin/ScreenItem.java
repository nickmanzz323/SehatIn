package com.example.sehatin;

public class ScreenItem {
    String Title, Description;
    int ScreenImg;

    public ScreenItem(String description, int screenImg, String title) {
        Description = description;
        ScreenImg = screenImg;
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
