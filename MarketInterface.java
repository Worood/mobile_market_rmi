/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Worood
 */
public interface MarketInterface extends Remote{
    public void addProduct(Product p, String category) throws RemoteException;
    public void removeProduct(Product p, String category) throws RemoteException;
    public ArrayList<Product> showProduct(String c) throws RemoteException;
    public ArrayList<Product> getCart() throws RemoteException;
    public float calc() throws RemoteException;
}
