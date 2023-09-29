/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6112a1_activity1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

public class StudentTest {

    // Test if a new student can be successfully added
    @Test
    public void testSaveStudent() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("12345\nCaiden\n20\nCaiden@gmail.com\nPROG6112");
        student.NewStudent(sc, mV);
        assertEquals(1, student.getstudentSize());
    }

    // Test if an existing student can be successfully searched
    @Test
    public void testSearchStudent() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("12345\nCaiden\n20\nCaiden@gmail.com\nPROG6112");
        student.NewStudent(sc, mV);
        Scanner searchScanner = new Scanner("12345");
        Data foundStudent = student.searchStudent(searchScanner, mV);
        assertNotNull(foundStudent);
        assertEquals(12345, foundStudent.getStudentID());
        assertEquals("Caiden", foundStudent.getName());
        assertEquals(20, foundStudent.getAge());
        assertEquals("Caiden@gmail.com", foundStudent.getEmail());
        assertEquals("PROG6112", foundStudent.getCourse());
    }

    // Test if a non-existing student returns null when searched
    @Test
    public void testSearchStudent_StudentNotFound() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("99999");
        Data foundStudent = student.searchStudent(sc, mV);
        assertNull(foundStudent);
    }

    // Test if an existing student can be successfully deleted
    @Test
    public void testDeleteStudent() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("12345\nCaiden\n20\nCaiden@gmail.com\nPROG6112");
        student.NewStudent(sc, mV);
        Scanner deleteScanner = new Scanner("12345\ny");
        student.removeStudent(deleteScanner, mV);
        assertEquals(0, student.getstudentSize());
    }

    // Test if attempting to delete a non-existing student keeps the number of students unchanged
    @Test
    public void testDeleteStudent_StudentNotFound() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("99999");
        student.removeStudent(sc, mV);
        assertEquals(0, student.getstudentSize());
    }

    // Test if a valid student age is correctly identified
    @Test
    public void testStudentAge_StudentAgeValid() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("20");
        boolean validAge = student.studentAge(sc, mV) >= 16;
        assertTrue(validAge);
    }

    // Test if an invalid student age is correctly identified
    @Test
    public void testStudentAge_StudentAgeInvalid() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("15");
        boolean validAge = student.studentAge(sc, mV) >= 16;
        assertFalse(validAge);
    }

    // Test if invalid character input for student age is handled correctly
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        Student student = new Student();
        MenuVisuals mV = new MenuVisuals();
        Scanner sc = new Scanner("NotANumber");
        int studentAge = student.studentAge(sc, mV);  // Note: You might want to add assertions here.
    }
}


