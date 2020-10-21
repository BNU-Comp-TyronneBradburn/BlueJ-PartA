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
    
    // The price of thee ticket 
    private int price;
    
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
    return price;
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
    
}
