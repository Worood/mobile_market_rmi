
import Shared.Category;
import Shared.Invoice;
import Shared.Product;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Shared.MarketInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Worood
 */
public class Server extends UnicastRemoteObject implements MarketInterface {
   private static int invoicecount =0;
    
   private static ArrayList<Product> htc;
   private static ArrayList<Product> samsung;
   private static ArrayList<Product> sony;
   private static ArrayList<Product> iphone;
   private static ArrayList<Product> huawei;
   private static ArrayList<Product> cart;
   private static ArrayList<Invoice> invoices;
    
    public Server()throws RemoteException {
         htc = new ArrayList<>();
        iphone = new ArrayList<>();
        sony = new ArrayList<>();
        huawei = new ArrayList<>();
        samsung = new ArrayList<>();
        cart = new ArrayList<>();
        invoices = new ArrayList<>();
        
        fill();
    }
 
    
    @Override
     public void addProduct(Product p, String c) {
         boolean b = false;
         System.out.println("Adding product");
        for(Product pr : cart){
        if(pr.getName().equals(p.getName()))
        {
            pr.setQty(pr.getQty()+1); 
            b = true;
        }
        } 
        if(!b)
        cart.add(new Product(p.getName(),p.getPrice(),1));
        
        if(c.equalsIgnoreCase("sony")){
               for(Product pr : sony){
                   if(pr.getName().equals(p.getName())){
                       pr.setQty(pr.getQty()-1);
                   }
               }
           }else if(c.equalsIgnoreCase("htc")){
               for(Product pr : htc){
                   if(pr.getName().equals(p.getName())){
                       pr.setQty(pr.getQty()-1);
                   }
               }
           }else if(c.equalsIgnoreCase("huawei")){
               for(Product pr : huawei){
                   if(pr.getName().equals(p.getName())){
                       pr.setQty(pr.getQty()-1);
                   }
               }
           }else if(c.equalsIgnoreCase("iphone")){
               for(Product pr : iphone){
                   if(pr.getName().equals(p.getName())){
                       pr.setQty(pr.getQty()-1);
                   }
               }
           }else {
             for(Product pr : samsung){
                   if(pr.getName().equals(p.getName())){
                       pr.setQty(pr.getQty()-1);
                   }
               }   
           }
     }

    @Override
    public ArrayList<Product> showProduct(String c) {
        if(c.equalsIgnoreCase("huawei")){
            return huawei;
        }else if(c.equalsIgnoreCase("sony")){
            return sony;
        } if(c.equalsIgnoreCase("iphone")){
         return iphone;
        } if(c.equalsIgnoreCase("htc")){
        return htc;
        }else 
            return samsung;
        
               }
   

    @Override
    public float calc() {
        int qty=0;
        float invoice =0,price=0,total=0;
        for(Product pr:cart)
        {
            price = pr.getPrice();
            qty = pr.getQty();
            total = price*qty;
            invoice+=total;
        }
        invoicecount++;
        Invoice in = new Invoice(invoicecount, invoice, cart);
        invoices.add(in);
        cart.clear();
        
        return invoice;
    }
    
   public void fill(){
        htc.add(new Product("Desire",  6550.2f,3));
        htc.add(new Product("kf",  6550.2f,8));
        htc.add(new Product("DesireT",  850.2f,0));
        htc.add(new Product("krjv",  6550.2f,15));
        htc.add(new Product("www",  650.2f,4));
       
        
        huawei.add(new Product("Gr3",  4550.2f,1));
        huawei.add(new Product("Mate10",  44450.2f,2));
        huawei.add(new Product("Gr5",  4550.2f,6));
        huawei.add(new Product("Gr2",  4550.2f,6));
        huawei.add(new Product("Gr9",  4550.2f,6));
        
        sony.add(new Product("Xperia C4",  850.2f,1));
        sony.add(new Product("Xperia C5",  8050.2f,9));
        sony.add(new Product("Xperia Z3",  4450.2f,0));
        sony.add(new Product("Xperia A4",  8050.2f,8));
        sony.add(new Product("Xperia Z9",  8050.2f,8));
        
        samsung.add(new Product("Duos",  50.2f,12));
        samsung.add(new Product("Young",  20.2f, 5));
        samsung.add(new Product("Edge",  1150.2f,8));
        samsung.add(new Product("A7",  5000.2f,2));
        samsung.add(new Product("A9",  5000.2f,2));
        
        iphone.add(new Product("Iphone X",  22222250.2f,1));
        iphone.add(new Product("Iphone 6+",  22250.2f,1));
        iphone.add(new Product("Iphone 7", 22250.2f,4));
        iphone.add(new Product("Iphone 5",  1111250.2f,1));
        iphone.add(new Product("Iphone 6s", 85250.2f,3));
        
       
   }
   
    @Override
    public ArrayList<Product> getCart() throws RemoteException {
        return cart;
    }

   public static void main(String args[]){
       System.out.println("Running Server...");
       
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("rmi://localhost//market", new Server());
            
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    @Override
    public void removeProduct(Product p, String c) throws RemoteException {
        boolean b = false;
         System.out.println("Removing product..");
        for(Product pr : cart){
        if(pr.getName().equalsIgnoreCase(p.getName()))
        {   System.out.println(pr.getName() + " "+ p.getName() );
            pr.setQty(pr.getQty()-1); 
            b = true;
        }
        } 
        
        if(c.equalsIgnoreCase("sony")){
               for(Product pr : sony){
                   if(pr.getName().equalsIgnoreCase(p.getName())){
                       System.out.println(pr.getName() + " "+ p.getName() );
                       pr.setQty(pr.getQty()+1);
                   }
               }
           }else if(c.equalsIgnoreCase("htc")){
               for(Product pr : htc){
                   if(pr.getName().equalsIgnoreCase(p.getName())){
                       System.out.println(pr.getName() + " "+ p.getName() );
                       pr.setQty(pr.getQty()+1);
                   }
               }
           }else if(c.equalsIgnoreCase("huawei")){
               for(Product pr : huawei){
                   if(pr.getName().equalsIgnoreCase(p.getName())){
                       System.out.println(pr.getName() + " "+ p.getName() );
                       pr.setQty(pr.getQty()+1);
                   }
               }
           }else if(c.equalsIgnoreCase("iphone")){
               for(Product pr : iphone){
                   if(pr.getName().equalsIgnoreCase(p.getName())){
                       System.out.println(pr.getName() + " "+ p.getName() );
                       pr.setQty(pr.getQty()+1);
                   }
               }
           }else {
             for(Product pr : samsung){
                   if(pr.getName().equalsIgnoreCase(p.getName())){
                       System.out.println(pr.getName() + " "+ p.getName() );
                       pr.setQty(pr.getQty()+1);
                   }
               }   
           }
    }
}
