/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Tyronne Bradburn
 */
public class TicketMachine
{
    
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    // The price of the ticket 
    private int Price;
    
    
    
    private Ticket issuedTicket;
    
    private Ticket aylesburyTicket;
    
    private Ticket amershamTicket;
    
    private Ticket highwycombeTicket;
    

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        
        balance = 0;
        total = 0;
        
        aylesburyTicket = new Ticket("Aylesbury", 220);
        amershamTicket = new Ticket("Amersham", 300);
        highwycombeTicket = new Ticket("High Wycombe", 330);
        
        issuedTicket = null;
    }

    /**
     * return the price of the ticket
     */
    public int getPrice()
    {
        return Price;
    }


    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * The machine will recive an amount from the customer 
     */
    public void insertMoney(Coin Value)
    {
        balance = balance + Value.getvalue();
    }
   
    /**
     * The machine will return the coins inserted.
     */
    public void printBalance (int amount)
    {
        System.out.println("amount inserted = "  + amount);
        System.out.println("current balance = " + balance);
    }

    
    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
    public void SelectaylesburyTicket()
    {
        issuedTicket = aylesburyTicket;
    }

    public void SelectamershamTicket()
    {
        issuedTicket = amershamTicket;
    }

    public void SelcethighwycombeTicket()
    {
        issuedTicket = highwycombeTicket;
    }

    

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
   
    /**
     * This shows what tickets are availabe on the machine.
     */
    public void printAllTickets()
    {
        printHeading();
        
        System.out.println();
        System.out.println("the following tickets are availabe:-");
        System.out.println();
        aylesburyTicket.print();
        System.out.println();
        amershamTicket.print();
        System.out.println();
        highwycombeTicket.print();
    }
  
    public void printHeading()
    {
        System.out.println("##################");
        System.out.println("# The Bradburn Line");
        System.out.println("# by Tyronne Bradburn");
        System.out.println("##################");    
        System.out.println();       
    }
    
    /**
     * 
     */
    public void printTicket()
    {
        int price = issuedTicket.getPrice();
   
        if(balance >=price)
        {
            System.out.println("##################");
        System.out.println("# The Bradburn Line");
        System.out.println("# by Tyronne Bradburn");
        issuedTicket.print();
        System.out.println("##################");    
        System.out.println();   
        
        total = total + price;
        
        balance = balance - price;
    }
    else
        {
        System.out.println("You must insert at least: " + 
                            (price - balance) + "more pence. ");
    }
                        
     }
    
    public void selectTicket(String whereTo)
    {
         if(whereTo.startsWith("Ayl"))
        {
            issuedTicket = aylesburyTicket;
        }
        else if(whereTo.startsWith("Ame"))
        {
            issuedTicket = amershamTicket;
        }
        else if(whereTo.startsWith("highwycombe"))
        {
            issuedTicket = highwycombeTicket;
        }
        else 
        {
            issuedTicket = null;
            System.out.println("Invalid Destination");
    }
    }

    
    public void insert10pCoin()
    {
        balance = balance + 10;
        printBalance(10);
    }
    
    public void insert20pCoin()
    {
        balance = balance + 20;
        printBalance(20);
    }
    
    public void insert100Coin()
    {
        balance = balance + 100;
        printBalance(100);
    }
    
     public void insert200Coin()
    {
        balance = balance + 200;
        printBalance(200);
        
    }
}