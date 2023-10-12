import java.util.Scanner;

class Student
{
    String name;
    int roll;
    int marks;
    Student(String name,int roll,int marks)
    {
        this.name=name;
        this.roll=roll;
        this.marks=marks;
    }
    void display()
    {
        System.out.println("Name: "+name);
        System.out.println("Roll: "+roll);
        System.out.println("Marks: "+marks);
    }
}


public class StudentMain
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n=sc.nextInt();
        Student[] s=new Student[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the name of student "+(i+1)+": ");
            String name=sc.next();
            System.out.println("Enter the roll number of student "+(i+1)+": ");
            int roll=sc.nextInt();
            System.out.println("Enter the marks of student "+(i+1)+": ");
            int marks=sc.nextInt();
            s[i]=new Student(name,roll,marks);
        }
        sc.close();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(s[j].marks<s[j+1].marks)
                {
                    Student temp=s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp;
                }
            }
        }
        System.out.println("The details of the students are: ");
        for(int i=0;i<n;i++)
        {
            s[i].display();
        }
    }
}

