import java.util.Scanner;

public class GradeEvaluation {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.println("-------------Student Grade Evaluation-------------");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = inputScanner.nextInt();  // 'numSubjects' for number of subjects
        
        int sumOfMarks = 0;  // 'sumOfMarks' instead of total
        
        System.out.println("Enter the marks obtained in " + numSubjects + " subjects respectively: ");
        for (int i = 0; i < numSubjects; i++) {
            int marks = inputScanner.nextInt();
            sumOfMarks += marks;  // Accumulating marks
        }
        
        // Calculate the Average Percentage (AP)
        double averagePercentage = (double) sumOfMarks / numSubjects;
        String studentGrade = "";  // For storing the grade
        
        // Determine grade based on average percentage
        if (averagePercentage >= 90) {
            studentGrade = "A+";
        } else if (averagePercentage >= 80) {
            studentGrade = "A";
        } else if (averagePercentage >= 70) {
            studentGrade = "B";
        } else if (averagePercentage >= 60) {
            studentGrade = "C";
        } else if (averagePercentage >= 50) {
            studentGrade = "D";
        } else if (averagePercentage >= 40) {
            studentGrade = "E";
        } else {
            studentGrade = "Fail(F)";
        }
        
        // Output the results
        System.out.println("Total Marks = " + sumOfMarks);
        System.out.printf("Average Percentage = %.2f%%\n", averagePercentage);
        System.out.println("Student Grade: " + studentGrade);
        
        inputScanner.close();  // Closing the scanner after use
    }
}
