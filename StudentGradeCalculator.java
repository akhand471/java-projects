import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student name:");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int total = 0;

        // Input loop
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            // Basic validation
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Enter between 0 to 100.");
                i--; // redo this subject
            } else {
                total += marks[i];
            }
        }

        double average = total / (double) n;
        char grade = calculateGrade(average);

        // Output
        System.out.println("\n===== Student Report Card =====");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total + "/" + (n * 100));
        System.out.println("Average: " + average + "%");
        System.out.println("Grade: " + grade);
    }

    // Method to calculate grade
    static char calculateGrade(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
}
