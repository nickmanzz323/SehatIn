package com.example.sehatin;

import java.util.Objects;

public class userRegistrationData {
    private String name;
    private String email;
    private String password;
    private String goal;
    private String gender;
    private String active;
    private int height;
    private int weight;
    private int age;
    private int calorieIntake;

    public userRegistrationData(){

    }

    // Getter
    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getGoal(){
        return this.goal;
    }

    public String getGender(){
        return this.gender;
    }

    public String getActive(){
        return this.active;
    }

    public int getHeight(){
        return this.height;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getAge(){
        return this.age;
    }

    public double getCalorieIntake(int height, int weight, int age, String gender){
        if(Objects.equals(gender, "male") || Objects.equals(gender, "Male"))
            return 66.5 + (13.75 * weight) + (5.003 * height) - (6.75 * age);

        else if(Objects.equals(gender, "female") || Objects.equals(gender, "Female"))
            return 655.1 + (9.563 * weight) + (1.85 * height) - (4.67 * age);

        else
            return 0;
    }

    // Setter
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setGoal(String goal){
        this.goal = goal;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setActive(String active){
        this.active = active;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setCalorieIntake(int calorieIntake){
        this.calorieIntake = calorieIntake;
    }
}
