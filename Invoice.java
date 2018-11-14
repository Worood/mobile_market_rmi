/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Worood
 */
public class Invoice implements Serializable{
    private int id;
    private float total;
    private ArrayList<Product> products;

    public Invoice() {
        products = new ArrayList<Product>();
    }

    public Invoice(int id, float total, ArrayList<Product> products) {
        this.id = id;
        this.total = total;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    public float calc(){
        for(Product p : products)
            total+=(p.getPrice()*p.getQty());
        return total;
       
    }
    
}
