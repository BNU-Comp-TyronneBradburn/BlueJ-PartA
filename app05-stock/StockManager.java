import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Tyronne Bradburn 
 * @version 30/10/2020
 */
public class StockManager
{
    public static final int RESTOCK_LEVEL = 3;
    
    // A list of the products.
    private ArrayList<Product> stock;
    
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product product)
    {
       stock.add(product); 
    }
    
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            stock.remove(product);
        }
        else
        {
            System.out.println("Enter a valid ID number");
        }
    }
    
    /**
     * Method to change the name of the product from the stock Manager
     */
    public void replaceName(int ID, String replacementName)
    {
        Product product = findProduct(ID);
        if(product != null)
        {
            product.changeName(ID, replacementName);
            System.out.println("Product Name Changed Successful" + product);
        }
        else 
        {
            System.out.println("Invalid ID");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
          product.increaseQuantity(amount);
          System.out.println("Product Delivered : " + product + " amount = " 
          + amount);
        }
        else
        {
            System.out.println("Product ID " + id + " NOT FOUND!!!");
        }
    }

    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProducts(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            printDetails(id);
            product.sell(amount);
            printDetails(id);
        }
    }
   
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printDetails(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() ==id)
            {
                return product;
            }
        }
        return null;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            return 0;
        }
        return product.getQuantity();
    }
    
    /**
     * Search for a product in stock with the products 
     * partial name
     */
    public void searchProduct(String name)
    {
        name = name.toLowerCase();
        
        for(Product product : stock)
        {
            if(product.getName().toLowerCase().contains(name))
            {
                System.out.println(product.toString());
            }
        }    
    }
    
    /**
     * Print products with Stock levels .
     */
    public void printLowStockProducts(int lowStockLevel)
    {
        System.out.println();
        for(Product product : stock)
        {
            
             if(product.getQuantity() <= lowStockLevel)
            {
                System.out.println(product);
            }
            
        }
    }
    
    /**
     * Print products with Stock levels .
     */
    public void restockProducts(int lowStockLevel, int restockLevel)
    {
        for(Product product : stock)
        {
             if(product.getQuantity() <= lowStockLevel)
            {
                product.increaseQuantity(restockLevel);
                System.out.println(product.getName() + " Low Stock");
                System.out.println("Has been restocked to " + restockLevel);
            }
        }
    }
    
    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
        System.out.println("====================");
        System.out.println("Tyronne's Stock");
        System.out.println("====================");
        for(Product product : stock)
        {
         System.out.println(product);   
        }
    }
}