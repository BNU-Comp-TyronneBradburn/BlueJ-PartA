
/**
 * This class is for students to enroll in and have an official UCAS code.
 *
 * @author Tyronne Bradburn
 * @version 7th October 2020
 */
public class Course
{
    // Attributes/Fields/Varibles
    private String title;
    
    private String codeNo; 
    

    /**
     * Constructor for creating Course.
     */
    public Course(String title, String codeNo)
    {
        this.title= title;
        this.codeNo= codeNo;
    }

    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println("Course; " +  title  +  codeNo);
    }
}



    
