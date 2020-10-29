
/**
 * This class is for students to enroll in and have an official UCAS code.
 *
 * @author Tyronne Bradburn
 * @version 28th October 2020
 */
public class Course
{
    // Attributes/Fields/Varibles
    private String title;
    
    private String codeNo; 
    
    private Module module1;
    
    private Module module2;
    
    private Module module3;
    
    private Module module4;
    
    private Grades finalGrade;
    
    private int finalMark;
    
    /**
     * Constructor for creating Course and gives students their final 
     * marks and grades.
     */
    public Course(String title, String codeNo)
    {
        this.title= title;
        this.codeNo= codeNo;
        
        this.finalMark = 0;
        this.finalGrade = null;
        
        createModules();
    }
    
    /**
     * This method allows to create the modules with their name
     */
    public void createModules()
    {
        module1 = new Module("CO454", "Digital Technologies");
        module2 = new Module("CO452", "Programming Concepts");
        module3 = new Module("CO450", "Networking");
        module4 = new Module("CO456", "Web Development");
    }
    
    /**
     * This is the method to add the module to the course
     */
    public void addModule(Module module, int moduleNo)
    {
        
        {
            if (moduleNo == 1)
        {
            this.module1 = module;
        }

        else if (moduleNo == 2)
        {
            this.module2 = module;
        }

        else if (moduleNo == 3)
        {
            this.module3 = module;
        }

        else if (moduleNo == 4)
        {
            this.module4 = module;
        }
        }
        }

    

    /**
     * This method is to award marks to studets 
     */
    public void setMark(int Mark, int moduleNo)
    {
        if(moduleNo == 1)
        {
            module1.awardMark(Mark);
        } 
        else if(moduleNo == 2)
        {
            module2.awardMark(Mark);
        }
        else if(moduleNo == 3)
        {
            module3.awardMark(Mark);
        }
        else if(moduleNo == 4)
        {
            module4.awardMark(Mark);
        }        
    }

    /**
     * this method calulates the final mark and grade for each module
     */
    public void calculateFinaleGrade()
    {
        if(coruseComplete())
        {
            int totalMark = module1.getMark() + module2.getMark() +
                module3.getMark() + module4.getMark();
            
                finalMark = totalMark /4;
                print();
        }
    }

    /**
     * This is the booleb method to say if the student has finiesd 
     * the course or not
     */
    public boolean coruseComplete()
    {
        if((module1.isCompleted()) && module2.isCompleted() && 
        module3.isCompleted() && module4.isCompleted())
        {
            return true;
        }
        else return false;
        
    }

    /**
     * This prints out the course details of what the student has to do 
     * for the course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
    }
    
    /**
     * This method prints out the modules and shows if the student
     * has passed or failed
     */
    public void printModules()
    {
        // print all the module marks
        module1.print();
        module2.print();
        module3.print();
        module4.print();
        
        if(coruseComplete())
        {
            System.out.println("Final Mark = " + finalMark);
            System.out.println("Final Grade = " + finalGrade);
        }
    }
    
    /**
     * Converts the module marks into grades. 
     */
    public void convertGrade(int mark)
    {
        if ((mark >= 0) && (mark < 40))
        {
            finalGrade = Grades.F;
        }

        else if ((mark >= 40) && (mark < 50))
        {
            finalGrade = Grades.D;
        }

        else if ((mark >= 50) && (mark < 60))
        {
            finalGrade = Grades.C;
        }

        else if ((mark >= 60) && (mark < 70))
        {
            finalGrade = Grades.B;
        }

        else if ((mark >= 70) && (mark < 100))
        {
            finalGrade = Grades.A;
        }
    }
    
    
}

















    
