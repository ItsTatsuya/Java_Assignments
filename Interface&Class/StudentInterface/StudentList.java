package StudentInterface;

import java.util.Scanner;

public class StudentList {
    public static Student[] getStudentDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of student " + (i + 1) + ": ");
            String name = sc.next();
            System.out.println("Enter the roll number of student " + (i + 1) + ": ");
            int roll = sc.nextInt();
            System.out.println("Enter the marks of student " + (i + 1) + ": ");
            int marks = sc.nextInt();
            students[i] = new Student(name, roll, marks);
        }

        sc.close();
        sortStudentsByMarks(students);
        return students;
    }

    private static void sortStudentsByMarks(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].marks < students[j + 1].marks) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
}
