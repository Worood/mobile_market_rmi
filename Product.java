/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.Serializable;

/**
 *
 * @author Worood
 */
public class Product implements Serializable{
    private String name;
 
    private float price;
    private int qty;

    public Product() {
    }

    public Product(String name, float price, int qty) {
        this.name = name;
     
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

   

    public float getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public void setPrice(float price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    
}
