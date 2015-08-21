// Avraham Moryosef
// CS 207
// 12/3/14
// Assignment 6

package gradebook;

import java.util.Scanner;

public class GradeBook
{
    //private data members:
    private String courseName;  //name of course
    private int grades [][];   //student grades and calculated averages stored within array
    
    //constructor:
    public GradeBook()
    {
        this.courseName = " ";
        this.grades = grades;
    }
    public GradeBook(String name, int gradesArray[][])//, int gradesArray)//, int [][]gradesArray) 
    {
         //a two-argument constructor to initialize courseName and grade
         this.courseName = name;
         this.grades = gradesArray;
    }
     //set/get methods: 
    public void setCourseName(String name)
    {
         this.courseName = name;
    }
     
     //single-argument method to set courseName
    public String getCourseName()
    {
         return(this.courseName);
    }
     //no-argument method to return courseName
     
     //auxiliary methods:
    public int getStudentLowestGrade()
    {
        int minVal = grades[0][1];
        int row = 0;
        int col = 0;

        for(row = 0; row < grades.length-1;)
        {
            for(col = 1; col < grades[row].length-1; col++)
            {
                if(grades[row][col] < minVal)
                {
                    minVal = grades[row][col];                    
                }
            }            
            System.out.println("The student's lowest grade for ID # " + grades[row][0] + " is: " + minVal);
            row++;
            minVal = grades[row][1];
        }
        return 0;
    }
     // no-arg method calculates and returns lowest grade

    public int getStudentHighestGrade()
    {
        int maxVal = grades[0][1];
        int row = 0;
        int col = 0;

        for(row = 0; row < grades.length-1; row ++)
        {
            for(col = 1; col < grades[row].length-1; col++)
            {
                if(grades[row][col] > maxVal)
                {
                    maxVal = grades[row][col];                    
                }
            }            
            System.out.println("The student's highest grade for ID # " + grades[row][0] + " is: " + maxVal);
            maxVal = 0;
        }
        return 0;
    }     
     // no-arg method calculates and returns highest grade 

    public int getStudentGradeAverage() //row average
    {
        int row = 0;
        int col = 0;
        int sum = 0;
        int avg = 0;
        
       for(row = 0 ; row <grades.length; row++) // how many students.  how many row
       {
           for(col = 1; col <grades[row].length - 1; col++)
           {
               sum = sum + grades[row][col]; 
           }
           avg = sum / (grades[row].length - 2);  // how many elements on a row.  how many test scores
           sum = 0;           
       }
       return avg;
    }
    //no-arg method calculates and returns the integer average of all grades

    public int getTestLowestGrade()
    {
        int minVal = grades[0][1];
        int row = 0;
        int col = 0;

        for(row = 0; row < grades.length-1; row++)
        {
            for(col = 1; col < grades[row].length-1; col++)
            {
                if(grades[row][col] < minVal)
                    minVal = grades[row][col];
            }
        }
        return (minVal);
    }
    // no-arg method calculates and returns lowest grade for a single test
    
    public int getTestHighestGrade()
    {
        int maxValue = grades[0][1];
        
        for(int row = 0; row < grades.length - 1; row++)
        {
            for(int col = 1; col < grades[row].length -1; col++)
            {
                if(grades[row][col] > maxValue)
                {
                    maxValue = grades[row][col];
                }
            }
        }    
        return(maxValue); 
    }
    
    // no-arg method calculates and returns highest grade for a single test

    public int getTestsAverage() //column average
    {
       int row = 0;
       int col = 0;
       int sum = 0;
            
       for(col = 1; col < grades[0].length; col++)
       {
           for(row = 0; row < grades.length - 1; row++)
           {
               sum = sum + grades[row][col];
           }
           grades[row][col] = sum / (grades.length-1);
           sum = 0;           
       }
       return sum;
    }
    //no-arg method calculates and returns the integer average of all test scores

    public void outputGrades()
    {       
       int row = 0;
       int col = 0;
     
        for(row = 0; row < grades.length - 1; row++)
       {
           col = 0;
           Scanner input = new Scanner(System.in);
           
           System.out.print("Enter student ID number: ");
           grades[row][col] = input.nextInt();
           
           System.out.println("Enter your score: ");
           
           int sum = 0;           
           for(col = 1; col < grades[row].length - 1; col++)
           {
               grades[row][col] = input.nextInt();
               sum += grades[row][col];
           }           
           grades[row][col] = sum / (grades[row].length - 2);
           System.out.println();
       }
       
       System.out.print("The name of the course is: " + getCourseName() + "\n");
       System.out.println("\nID #\ttest1\ttest2\ttest3\taverage");
       
       for(row = 0 ; row < grades.length; row++)
       {
           for(col = 0; col < grades[row].length; col++)
           {
               getTestsAverage();
               System.out.print(grades[row][col] + "\t");
           }
           System.out.println();
       }
    }
    // no-arg method displays all grades stored in GradeBook

    //optional method:
    public void processGrades( )
    {
        System.out.println("Enter the student ID number followed by the test scores: \n" );
        outputGrades();
        System.out.println();
        getStudentLowestGrade();
        System.out.println();
        getStudentHighestGrade();
        System.out.print("\nThe class grade average is: " + getStudentGradeAverage() +
                        "\nThe lowest grade of the class is: " + getTestLowestGrade() +
                        "\nThe highest grade of the class is: " + getTestHighestGrade());       
    }
}