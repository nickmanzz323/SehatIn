package com.example.sehatin;

public class IntroItem {

    private String Title, Description;
    private int itemImage;

    public IntroItem(String title, String description, int itemImage){
        this.Title = title;
        this.Description = description;
        this.itemImage = itemImage;
    }

    public void setTitle(String title){
        this.Title = title;
    }

    public void setDescription(String description){
        this.Description = description;
    }

    public void setItemImage(int itemImage){
        this.itemImage = itemImage;
    }

    public String getTitle(){
        return this.Title;
    }

    public String getDescription(){
        return this.Description;
    }

    public int getItemImage(){
        return this.itemImage;
    }
}
