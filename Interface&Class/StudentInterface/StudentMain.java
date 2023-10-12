package StudentInterface;

public class StudentMain {
    public static void main(String[] args) {
        Student[] students = StudentList.getStudentDetails();

        System.out.println("The details of the students are: ");
        for (int i = 0; i < students.length; i++) {
            students[i].display();
        }
    }
}
