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
public class Category implements Serializable{
    private String name;
    private int id;
    private ArrayList<Product> products;

    public Category() {
        products = new ArrayList<>();
    }

    public Category(String name, int id, ArrayList<Product> products) {
        this.name = name;
        this.id = id;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public void addProduct(Product p){
        products.add(p);
    }
    public void removeProduct(Product p){
        products.remove(p);
    }
    
    
}
