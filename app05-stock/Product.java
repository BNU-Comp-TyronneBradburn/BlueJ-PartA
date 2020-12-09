/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;
    
    private int lowStockLevel;
    
    private int restockLevel;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
        this.lowStockLevel = 3; 
        this.restockLevel = 5;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                " with a non-positive amount: " + amount);
        }
    }
    
    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + " stock level: " + quantity;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void deliver(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                               " with a non-positive amount: " + 
                               amount);
        }
    }

    /**
     * Selling a quantity of this products.
     * An error is reported if there appears to be no stock.
     */
    public void sellProduct(int amount)
    {
        if(quantity >= amount && quantity > 0) 
        {
            quantity -= amount;
            System.out.println("Sold" + amount + "of" + name);
        }
        else if(amount > quantity && quantity > 0)
        {
           System.out.println("Insufficient Stock = " + quantity +
            " amount ordered = " + amount);
           quantity = 0;
        }
        else
        {
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
        }
    }
    
     /**
     * Method to Sell one product.
     */
    public void sellOne()
    {
        if(quantity > 0) 
        {
            quantity--;
        }
        else 
        {
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
        }
    }
    
    public int getLowStockLevel()
    {
        return lowStockLevel;
    }
    
    /**
     * Sell one of these products.
     * Otherwise a error message will appeat
     */
    public void sellAmount()
    {
        if(quantity > 0) 
        {
            quantity --;
        }
        else 
        {
            System.out.println();
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
            System.out.println();
        }
    }
    
}
