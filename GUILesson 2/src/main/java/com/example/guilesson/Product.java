package com.example.guilesson;

public class Product {
    public String name;

    private int quantity;
    private double cost;

    Product(String n, int quant, double cost){
        name = n;
        quantity = quant;
        this.cost = cost;

    }

    //getters and setters

    public void addQuantity(int amt) {
        quantity += amt;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void purchase(){
        quantity--;
    }
    public double getCost(){
        return cost;
    }
    public String toString(){
        return name;

    }
}
