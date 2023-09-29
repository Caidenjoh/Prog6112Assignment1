/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6112a1_activity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    // List to store the data of all students
    private List<Data> student;

    // Constructor to initialize the student list
    public Student(){
        this.student = new ArrayList<>();
    }
    
    // Method to capture and add new student details
    public void NewStudent(Scanner sc, MenuVisuals mV) {
        System.out.println(MenuVisuals.CAPTURE_STUDENT);
        System.out.println("Enter the student id: ");
        int studentID = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        System.out.println("Enter the student name: ");
        String name = sc.nextLine();

        // Call method to get student's age and ensure it's valid
        int age = studentAge(sc, mV);
        
        System.out.println("Enter the student email: ");
        String email = sc.nextLine();
        
        System.out.println("Enter the student course: ");
        String course = sc.nextLine();

        // Add the student data to the student list
        student.add(new Data(name, email, course, studentID, age));
        System.out.println("Student successfully captured");
    }
    
    // Method to search for a student by their ID
    public Data searchStudent(Scanner sc, MenuVisuals mV){
        System.out.println(MenuVisuals.SEARCH_STUDENT_PROMPT);
        int searchId = sc.nextInt();

        // Loop through student list to find the student
        for (Data data : student){
            if (data.getStudentID() == searchId){
                return data;
            }
        }
        System.out.println("Student with student id: " + searchId + " was not found");
        return null;
    }
    
    // Method to remove a student from the student list
    public Data removeStudent(Scanner sc, MenuVisuals mV){
        System.out.println(MenuVisuals.REMOVE_STUDENT_PROMPT);
        int removeId = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        
        for (Data data : student){
            if (data.getStudentID() == removeId){
                System.out.println("Are you sure you want to delete student " + removeId + " from the system? Yes (y) to delete.");
                String confirm = sc.nextLine();
                if(confirm.equals("y")){
                    student.remove(data);
                    System.out.println("Student with student id: " + removeId + " WAS deleted!");
                    return null;
                }
            } else {
                System.out.println("No student with student id: " + removeId + " was found");
            }
        }
        return null;
    }
    
    // Method to display the list of all students
    public void listStudents(MenuVisuals mV){
        if(student.isEmpty()){
            System.out.println(MenuVisuals.STUDNT_INFO_EMPTY);
        }else{
            System.out.println(MenuVisuals.LIST_STUDENTS);
            int num = 1;  // Counter to display student number
            for(Data data : student){
                System.out.println("STUDENT " + num);
                System.out.println("------------------------------");
                System.out.println("STUDENT ID: " + data.getStudentID());
                System.out.println("STUDNT NAME: " + data.getName());
                System.out.println("STUDENT AGE: " + data.getAge());
                System.out.println("STUDENT EMAIL: " + data.getEmail());
                System.out.println("STUDENT COURSE: " + data.getCourse());
                num++;
            }
        }
    }
    
    // Method to get the total number of students in the list
    public int getstudentSize(){
        return student.size();
    }
    
    // Method to capture and validate student's age
    public int studentAge(Scanner sc, MenuVisuals mV) {
        int age;
        while (true) {
            System.out.println("Enter the student age: ");
            age = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            // Ensure student's age is greater than 16
            if (age > 16) {
                return age; // Valid age, return it
            } else {
                System.out.println(MenuVisuals.INCORRECT_AGE);
                System.out.println("Please re-enter the student age >>>");
            }
        }
    }
}




