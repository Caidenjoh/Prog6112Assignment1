
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6112a1_activity1;

import java.util.Scanner;

public class PROG6112A1_Activity1 {

    public static void main(String[] args) {
        // Instantiate objects for managing student data and displaying menu visuals
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner(System.in);
        
        // Display the initial start menu and menu options
        System.out.println(mV.START_MENU);
        System.out.println(mV.MENU_OPTION);
        
        int start = sc.nextInt();
        sc.nextLine();
        
        // Check if user wants to launch the menu or exit
        if (start == 1){
            // Flag to keep the application running
            boolean continueApp = true;
            
            // Main loop to keep presenting options until user exits
            while(continueApp){
                // Display the main menu choices
                System.out.println(mV.SELECT_ITEM);
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print Student report.");
                System.out.println("(5) Exit Application.");
                
                // Read user's choice
                int choice = sc.nextInt();
                sc.nextLine();
                
                // Switch case to handle different user choices
                switch(choice){
                    case 1:
                        // Option to capture a new student's data
                        student.NewStudent(sc, mV);
                        break;
                    case 2:
                        // Option to search for an existing student
                        Data foundStudent = student.searchStudent(sc, mV);
                        
                        // If the student is found, display their details
                        if(foundStudent != null){
                            System.out.println("STUDENT ID: " + foundStudent.getStudentID());
                            System.out.println("STUDNT NAME: " + foundStudent.getName());
                            System.out.println("STUDENT AGE: " + foundStudent.getAge());
                            System.out.println("STUDENT EMAIL: " + foundStudent.getEmail());
                            System.out.println("STUDENT COURSE: " + foundStudent.getCourse());
                        }
                        break;
                    case 3:
                        // Option to remove a student's data
                        student.removeStudent(sc, mV);
                        break;
                    case 4:
                        // Option to list all the students
                        student.listStudents(mV);
                        break;
                    case 5:
                        // Option to exit the application
                        continueApp = false;
                        System.out.println(mV.EXIT_MESSAGE);
                        break;
                    default:
                        // Handle invalid choices
                        System.out.println("invaild choice. Please enter a valid option");
                        break;
                }
            }
        }
    }
}
