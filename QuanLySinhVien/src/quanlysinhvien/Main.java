/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        int choice;

        do {
            System.out.println("\t\t***STUDENT MANAGEMENT SYSTEM***");

            System.out.println("1. Add new student\t\t\t2. Delete student by id");
            System.out.println("3. Update student by id\t\t\t4. List all students");
            System.out.println("5. Sort students by id\t\t\t6. Sort students by GPA");
            System.out.println("7. Sort students by first name\t\t8. Sort students by last name");
            System.out.println("9. Find student with highest GPA\t10. Save to file");
            System.out.println("11. Load from file\t\t\t0. Exit");

            System.out.print("Enter your choice (0-11): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.deleteStudent();
                    break;
                case 3:
                    system.updateStudent();
                    break;
                case 4:
                    system.listAllStudents();
                    break;
                case 5:
                    system.sortStudentsBySID();
                    break;
                case 6:
                    system.sortStudentsByGPA();
                    break;
                case 7:
                    system.sortStudentsByFirstName();
                    break;
                case 8:
                    system.sortStudentsByLastName();
                    break;
                case 9:
                    system.findStudentWithHighestGPA();
                    break;
                case 10:
                    if (system.isStudentListEmpty()) {
                        System.out.println("The student list is empty. Do you want to continue? (y/n): ");
                        String continueChoice = scanner.nextLine().toLowerCase();

                        if (!continueChoice.equals("y")) {
                            break;
                        }
                    }
                    System.out.print("Do you want to replace all data in the file? (y/n): ");
                    String replaceChoice = scanner.nextLine().toLowerCase();
                    if (replaceChoice.equals("y")) {
                        system.saveToFileAtAll();
                    } else if (replaceChoice.equals("n")) {
                        system.saveToFileAtEnd();
                    } else {
                        System.out.println("Invalid choice. Please enter 'y' to replace all data or 'n' to append.");
                    }
                    break;

                case 11:
                    system.loadFromFile();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 21.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
