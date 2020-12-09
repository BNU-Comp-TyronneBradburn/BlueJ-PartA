
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
    public static final int FIRST_ID = 101;
    public static final int LAST_ID = 120;
    
    // The stock manager.
    private StockManager manager;
    
    private Random generator;
    
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        generator = new Random();
        
        manager.addProduct(new Product(FIRST_ID,  "Xbox X"));
        manager.addProduct(new Product(102,  "PS5"));
        manager.addProduct(new Product(103,  "PS4"));
        manager.addProduct(new Product(104,  "Xbox S"));
        manager.addProduct(new Product(105,  "Apple Iphone 12"));
        manager.addProduct(new Product(106,  "Apple Iphone 12 Max"));
        manager.addProduct(new Product(107,  "Sony xperia 5 II"));
        manager.addProduct(new Product(108,  "Google Pixel 4A"));
        manager.addProduct(new Product(109,  "Huawei P40"));
        manager.addProduct(new Product(LAST_ID,  "Huawei P40 Pro"));
        
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
        
        for(int id = FIRST_ID; id <= LAST_ID; id++)
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
        
        demoDeliveryProducts();
        
        manager.printAllProducts();
        
        demoSellProducts();
        
        manager.printAllProducts();
    }
    
    private void demoSellProducts()
    {
        System.out.println("Sell");
        
        int quantity = 0;
        
        for(int id = FIRST_ID; id <= LAST_ID; id++)
        {
            quantity = generator.nextInt(8);
            Product product = manager.findProduct(id);
            manager.sellProducts(id, quantity);
        }
        
        manager.printAllProducts();
    }
    
    private void demoDeliveryProducts()
    {
        System.out.println("Demonstarting Product Devlivery");
        int amount = 0;
        
        for(int id = FIRST_ID; id<=LAST_ID; id++)
        {
            amount = generator.nextInt(8);
            manager.deliverProduct(id, amount);
            amount++;
        }
        
    }
 
}
    
    

