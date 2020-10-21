import java.util.Date;


/**
 * This class is the ticket which will be printed from the ticket machine.
 *
 * @author Tyronne Bradburn
 * @version 14/10/2020
 */
public class Ticket
{
    // Fields, attributes, variables
    
    private String destination;
    
    // This is the price of the ticket in GBP 
    private int price;
    
    //Date and time 
    private Date dateTime;
    
    /**
     * This is the ticket which shows the price, destination and the date 
     * of the ticket
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
        dateTime = new Date(); 
    }
public String returnDestination()
{
    return destination;
}

public int returnPrice()
{
    return price;
}

public String toString()
{
    return destination+ "" + price + "" +  dateTime;
}

   public void print()
   {
       System.out.print(" Ticket to " + destination);
       System.out.print(" " + price + " pence ");
       System.out.println(" issued @ " + dateTime);
   }
} 
