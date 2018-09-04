package com.ovlab.menu_project;

/**
 * Created by 김준영 on 2018-08-27.
 */

public class FoodDTO {
    private String food_name;
    private int food_price;
    private int imgID;
    private int quantity;

    public FoodDTO(String food_name, int food_price, int imgID) {
        this.food_name = food_name;
        this.food_price = food_price;
        this.imgID = imgID;
    }

    public FoodDTO(String food_name, int food_price, int imgID, int quantity) {
        this.food_name = food_name;
        this.food_price = food_price;
        this.imgID = imgID;
        this.quantity = quantity;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getFood_price() {
        return food_price;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
