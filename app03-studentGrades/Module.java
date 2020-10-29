
/**
 * This class shows the modlues for the course and shows the marks for them
 * and it shows if the student has enough marks to pass or fail
 *
 * @author Tyronne Bradburn
 * @version 28th October 2020
 */
public class Module
{
    // Attributes/Fields/Varibles
    private String title;
    
    private String codeNo;
    
    private int mark;
    
    private int credit;
    
    private boolean completed;
    
    private boolean passed;

    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String codeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
        
        mark = -1;
        credit = 15;
        
        passed = false;
        completed = false;
    }

    /**
     * This is the method to show if the student has enough marks to 
     * pass.
     */
    public void awardMark(int mark)
    {
        this.mark = mark;
    }
    
    /**
     * This method shows the mark
     */
    public int getMark()
    {
        return mark;
    }
    
    /**
     * this method is able to return the module unquie code number
     */
    public String getCodeNo()
    {
        return codeNo;
    }
    
    /**
     * This boolean shows if the Course has been complete or not by the 
     * student
     */
    public boolean isCompleted()
    {
        return mark >= 40;
    }
    
    /**
     * This method is able to print the Mark, code number and Module
     */
    public void print()
    {
        System.out.println("Module: " + title + " " + codeNo + " Mark = " 
        + mark); 
    }
    
    /**
     * This method allows to title the modules
     */
    public String getTitle()
    {
        return this.title;
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
