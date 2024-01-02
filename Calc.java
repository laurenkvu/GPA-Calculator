import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * the Calc class calculates the GPA based on their current grades in their classes. This is based on the PISD 5.0 scale.
 * @author Lauren Vu
 */
public class Calc {
    public static void main (String[] args) {
        // constants 
        final double HONORS = 0.5;
        final double REG = 1.0;
        final double MOD = 1.5;
        final double APPLIED = 2.5;
        // variables
        int numClasses = 0;
        String className;
        String classType;
        int classGrade;
        double sumGPA = 0;
        String classInfo = "\n";
        double currentClassGPA;

        try {
            Scanner input = new Scanner(System.in);
            System.out.print("How many classes are you currently taking? ");
            numClasses = input.nextInt();
            
            // loop that runs based on number of classes student is taking
            for (int i = 1; i <= numClasses; i++) {
                input.nextLine();
                System.out.print("\nEnter name of class #" + i + ": "); 
                className = input.nextLine();
                System.out.print("\nEnter type of class #" + i + " (AP, honors, regular, modified, or applied): ");
                classType = input.next();
                if (!( classType.equalsIgnoreCase("AP") || classType.equalsIgnoreCase("honors") || classType.equalsIgnoreCase("regular") || classType.equalsIgnoreCase("modified") || classType.equalsIgnoreCase("applied") )) throw new IllegalArgumentException();

                System.out.print("\nEnter grade of class #" + i + ": ");
                classGrade = input.nextInt();
                
                // calculates induvidual GPA of each class
                if (classType.equalsIgnoreCase("AP")) currentClassGPA = getGPA(classGrade);
                else if (classType.equalsIgnoreCase("honors")) currentClassGPA = getGPA(classGrade) - HONORS;
                else if (classType.equalsIgnoreCase("regular")) currentClassGPA = getGPA(classGrade) - REG;
                else if (classType.equalsIgnoreCase("modified")) currentClassGPA = getGPA(classGrade) - MOD;
                else  currentClassGPA = getGPA(classGrade) - APPLIED;
                sumGPA += currentClassGPA;

                // forms the display for each class and its respective GPA and grade
                classInfo += className + ": " + currentClassGPA + " (" + classGrade + ")\n";

              }
         
         
        System.out.println(classInfo);
        System.out.printf("Overall GPA: %.2f", sumGPA/numClasses);
         }

        catch (InputMismatchException E) {
            System.out.println("Sorry, invalid argument detected. Enter an INTEGER next time. Program terminated.");
         }
         catch (IllegalArgumentException iae) {
            System.out.println("Sorry, invalid argument detected. Enter a VALID CLASS TYPE next time: AP, honors, regular, modified, or applied. Program terminated.");
         }

    }
    /** This method calculates the student's GPA given the student's grade in the class. 
     *  @param grade the student's grade in the specified class
     *  @return student's GPA (assuming AP class for now; will be modified accordingly in main method)
     */
    public static double getGPA(int grade) {
        if (grade >= 97) return 5.0;
        else if (grade >= 93 && grade <= 96) return 4.8;
        else if (grade >= 90 && grade <= 92) return 4.6;
        else if (grade >= 87 && grade <= 89) return 4.4;
        else if (grade >= 83 && grade <= 86) return 4.2;
        else if (grade >= 80 && grade <= 82) return 4.0;
        else if (grade >= 77 && grade <= 79) return 3.8;
        else if (grade >= 73 && grade <= 76) return 3.6;
        else if (grade >= 71 && grade <= 72) return 3.4;
        else if (grade == 70) return 3.0;
        else return 0;
    }
}