
/**
 * Enumeration class Coin - This class can allow the custmers in insert 
 * some coins into the machine.
 *
 * @author Tyronne Bradburn
 * @version 14/10/2020
 */

public enum Coin
{
    P10 (10),
    P20 (20),
    P100 (100),
    P200 (200);
    
    private final int value;
    
    private Coin(int value)
    
    {
        this.value = value;
}

public int getvalue()

{ 
    return value;
}
}