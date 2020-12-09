
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
    public static final String ADD_PRODUCT = "add";
    public static final String REMOVE_PRODUCT = "remove";
    public static final String DELIVER_PRODUCT = "deliver";
    public static final String SELL_PRODUCT = "sell";
    public static final String SEARCH_PRODUCT = "search";
    public static final String LOW_STOCK = "lowstock";
    public static final String RESTOCK_PRODUCTS = "restock";
    public static final String PRINT_ALL = "printall";
    public static final String QUIT_PROGRAM = "quit";
    
    // Use to get user input
    private InputReader reader;
    private StockManager manager;
    private StockDemo oldStock;
    private Product product;
    private int id;
    private int amount;
    private String name;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
        oldStock = new StockDemo(manager);    
        product = new Product(id, name);
        this.id = id;
        this.amount = amount;
        this.name = name;
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
            if(choice.equals(QUIT_PROGRAM))
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
        if(choice.equals(ADD_PRODUCT))
        {
            addProduct();
        }
        else if(choice.equals(REMOVE_PRODUCT))
        {
            removeProduct();
        }
        else if(choice.equals(DELIVER_PRODUCT))
        {
            deliverProduct();
        }
        else if(choice.equals(SELL_PRODUCT))
        {
            sellProduct();
        }
        else if(choice.equals(SEARCH_PRODUCT))
        {
            searchProduct();
        }
        else if(choice.equals(LOW_STOCK))
        {
            printLowStockProducts();
        }
        else if(choice.equals(RESTOCK_PRODUCTS))
        {
            restockAllProducts();
        } 
        else if(choice.equals(PRINT_ALL))
        {
            printAllProducts();
        }
    }
    
    private void getAddInput()
     {
        System.out.println("Adding a new product");

        System.out.println("\nPlease enter the product ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the product name");
        name = reader.getInput();
     }
    
    /**
     * Method to add a new product with a ID number 
     */
    private void addProduct()
    {
       getAddInput();
       if(manager.findProduct(id) == null)
        {
            Product product = new Product(id, name);
            manager.addProduct(product);
        }
        else
        {
            System.out.println("\n------------------------------------");
            System.out.println("Product ID " + id + " already in use");
            System.out.println("------------------------------------");
        }
    }
    
    /**
     * User input for removeProduct method.
     */
    private void getRemoveInput()
    {
        System.out.println("Removing an existing product");

        System.out.println("\nPlease enter the product ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        name = reader.getInput();
    }
    
     /**
     * Method to remove Products 
     */
    private void removeProduct()
    {
        getRemoveInput();
        product = new Product(id, name);
        manager.removeProduct(id);
    }
    
    private void getDeliverInput()
    {
        System.out.println("Delivering a product");

        System.out.println("\nPlease enter the product ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the amount to be delivered ");
        String quantity = reader.getInput();
        amount = Integer.parseInt(quantity);
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
    
    /**
     * method to restock products
     */
    private void restockAllProducts()
    {
        int lowStock = reader.getInt("Please enter the low stock level") ;      
        int reStock = reader.getInt("Please enter the restock level");
        
        manager.restockProducts(lowStock, reStock);
    }
    
    /**
     * method to sell products
     */
    private void getSellInput()
    {
        System.out.println("Selling an item");

        System.out.println("Please enter the item ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the quantity to sell ");
        String quantity = reader.getInput();
        amount = Integer.parseInt(quantity);
    }
    
    private void sellProduct()
    {
        getSellInput();
        manager.sellProducts(id, amount);
    }
    
    /**
     * method to print low stock
     */
    private void printLowStockProducts()
    {
        System.out.println("Products that are low on stock:");

        int lowStockLevel = product.getLowStockLevel();
        manager.printLowStockProducts(lowStockLevel);
    }
    
    /**
     * method to restock products
     */
    public void restockProduct()
    {
        int id = reader.getInt(" Please enter the product id >") ; 
        int reStock = reader.getInt(" Please enter the restock level");
        
        manager.deliverProduct(id, reStock);
    }
    
    /**
     * method to search for product
     */
    private void searchProduct()
    {
        System.out.println("Searching for a product");

        System.out.println("Please enter a keyword");
        String name = reader.getInput();

        manager.searchProduct(name);
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
        System.out.println("    Sell:       Selling an product");
        System.out.println("    Search:     Search for an product");
        System.out.println("    Low Stock:  Low Stock products");
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
