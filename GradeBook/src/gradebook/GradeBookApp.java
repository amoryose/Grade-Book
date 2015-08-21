// Avraham Moryosef
// CS 207
// 12/3/14
// Assignment 6

package gradebook;

public class GradeBookApp
{
    public static void main(String [] args)
    {
        int [][] scores = new int [4][5];
      
        GradeBook grades = new GradeBook("Math", scores);
                
        grades.processGrades();
    }    
}

