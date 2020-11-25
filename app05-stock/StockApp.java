
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Tyronne Bradburn
 * @version 11/11/2020
 */
public class StockApp
{
    public static final String PRINT_ALL = "printall";
    
    // Use to get user input
    private InputReader reader;
    
    private StockManager manager;
    
    private StockDemo oldStock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
        oldStock = new StockDemo(manager);
    }

    /**
     * Method to bring up the menu
     */
    public void run()
    {       
        getMenuChoice();
    }
    
    /**
     * allows the the user to use the choices
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString();
            
            
            choice = choice.toLowerCase();
            if(choice.equals("quit"))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
            
        }
    }
    
    private void executeMenuChoice(String choice)
    {
        if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            removeProduct();
        }
        else if(choice.equals(PRINT_ALL))
        {
            printAllProducts();
        }
        else if(choice.equals("deliver"))
        {
            deliverProduct();
        }
        else if(choice.equals("restock"))
        {
            restockAllProducts();
        }        
    }
    
    /**
     * Method to add a new product with a ID number 
     */
    private void addProduct()
    {
        System.out.println("Adding a new product");
        
        System.out.println("Please enter the product ID");
        String value = reader.getString();
        int id = Integer.parseInt(value);
        
        System.out.println("Please enter product name");
        String name = reader.getString();
        
        Product product = new Product(id, name);
        System.out.println("Added new product " + product);
        
        manager.addProduct(product);
    }
    
    /**
     * Method to remove Products 
     */
    private void removeProduct()
    {
       System.out.println("Removing a product");
        
       System.out.println("Please enter the product ID");
       String value = reader.getString();
       int id = Integer.parseInt(value);
   
       System.out.println("Removed product");
        
       manager.removeProduct(id);
    }
    
    /**
     * Method to deliver Products
     */
    private void deliverProduct()
    {
        int id = reader.getInt("Please enter the product ID");
        int amount = reader.getInt("Please enter the Amount > ");
      
        manager.deliverProduct(id, amount);
    }
    
    private void restockAllProducts()
    {
        int lowStock = reader.getInt("Please enter the low stock level") ;      
        int reStock = reader.getInt("Please enter the restock level");
        
        manager.restockProducts(lowStock, reStock);
    }
    
    
    public void restockProduct()
    {
        int id = reader.getInt(" Please enter the product id >") ; 
        int reStock = reader.getInt(" Please enter the restock level");
        
        manager.deliverProduct(id, reStock);
    }
    
    /**
     * Method to Print all the Products
     */
    private void printAllProducts()
    {
        manager.printAllProducts();
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Deliver:    Deliver an old product");
        System.out.println("    Restock:    Restock all products");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("  App05: by Tyronne Bradburn");
        System.out.println("******************************");
    }
}
