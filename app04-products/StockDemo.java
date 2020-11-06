import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    
    private Random generator;
    
    private String name = "Samsung Galaxy";
    
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        generator = new Random();
        
        
        manager.addProduct(new Product(101, "Samsung Galaxy S10"));
        manager.addProduct(new Product(102,  "Samsubg Galaxy S10 Plus"));
        manager.addProduct(new Product(103,  "Samsung Galaxy S20"));
        manager.addProduct(new Product(104,  "Samsung Galaxy S20 Plus"));
        manager.addProduct(new Product(105,  "Apple Iphone 12"));
        manager.addProduct(new Product(106,  "Apple Iphone 12 Max"));
        manager.addProduct(new Product(107,  "Sony xperia 5 II"));
        manager.addProduct(new Product(108,  "Google Pixel 4A"));
        manager.addProduct(new Product(109,  "Huawei P40"));
        manager.addProduct(new Product(110,  "Huawei P40 Pro"));
        
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void demoDemo()
    {
        // Show details of all of the products.
        manager.printAllProducts();
        // Take delivery of 5 items of one of the products.
        int quantity = 0;
        
        for(int id = 101; id <= 110; id++)
        {
            quantity = generator.nextInt(8);
            Product product = manager.findProduct(id);
            product.increaseQuantity(quantity);
        }
        
        manager.printAllProducts();
    }
    
    
    
    
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
        
    }
    
    
    public void runDemo()
    {
        manager.printAllProducts();
        demoDelivery();
        demoSell();
    }
    
    private void demoSell()
    {
        int quantity = 0;
        
        for(int id = 101; id <= 110; id++)
        {
            quantity = generator.nextInt(8);
            Product product = manager.findProduct(id);
            product.sellProduct(id, amount);
        }
        
        manager.printAllProducts();
    }
    
    private void demoDelivery()
    {
        System.out.println("/nDemonstarting Product Devlivery/n");
        int amount = 0;
        
        for(int id = 101; id<=110; id++)
        {
            amount = generator.nextInt(8);
            manager.deliverProduct(id,amount);
            amount++;
        }
        
    }
        
}
    
    

