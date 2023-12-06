package quanlysinhvien;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class StudentManagementSystem {

    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void saveToFileAtAll() {
        String filePath = "D:/OOP/QuanLySinhVien/src/quanlysinhvien/ListStudents.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.println(student.getSid() + "," + student.getLastName() + "," + student.getFirstName() + "," + student.getMajor() + "," + student.getGpa());
            }
            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFileAtEnd() {
        String filePath = "D:/OOP/QuanLySinhVien/src/quanlysinhvien/ListStudents.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            for (Student student : students) {
                writer.println(student.getSid() + "," + student.getLastName() + "," + student.getFirstName() + "," + student.getMajor() + "," + student.getGpa());
            }
            System.out.println("Data appended to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        String filePath = "D:/OOP/QuanLySinhVien/src/quanlysinhvien/ListStudents.txt";

        List<Student> loadedStudents = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int sid = Integer.parseInt(parts[0]);
                String lastName = parts[1];
                String firstName = parts[2];
                String major = parts[3];
                double gpa = Double.parseDouble(parts[4]);

                loadedStudents.add(new Student(sid, lastName, firstName, major, gpa));
            }
            System.out.println("Data loaded from " + filePath);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        students = loadedStudents;
    }

    public void addStudent() {
        System.out.print("Enter student SID: ");
        int sid = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();

        students.add(new Student(sid, lastName, firstName, major, gpa));
        System.out.println("Student added successfully!");
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int deleteId = scanner.nextInt();

        boolean studentDeleted = students.removeIf(student -> student.getSid() == deleteId);

        if (studentDeleted) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found with ID: " + deleteId);
        }
    }

    public void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean studentFound = false; // Flag to track if the student is found

        for (Student student : students) {
            if (student.getSid() == updateId) {
                studentFound = true;
                break; // No need to continue searching if the student is found
            }
        }

        if (studentFound) {
            // Student found, allow further updates if needed
            System.out.print("Enter new last name: ");
            String newLastName = scanner.nextLine();
            System.out.print("Enter new first name: ");
            String newFirstName = scanner.nextLine();
            System.out.print("Enter major: ");
            String newMajor = scanner.nextLine();
            System.out.print("Enter new GPA: ");
            double newGPA = scanner.nextDouble();

            // Update student information
            for (Student student : students) {
                if (student.getSid() == updateId) {
                    student.setLastName(newLastName);
                    student.setFirstName(newFirstName);
                    student.setMajor(newMajor);
                    student.setGpa(newGPA);
                    System.out.println("Student updated successfully!");
                    return;
                }
            }
        } else {
            // Student not found
            System.out.println("Student not found with ID: " + updateId);
        }
    }

    public void listAllStudents() {
        System.out.println("+--------------------------------------------------------------+");
        System.out.printf("| %-4s | %-15s | %-15s | %-10s | %-4s |\n", "SID", "LAST NAME", "FIRST NAME", "MAJOR", "GPA");
        System.out.println("+--------------------------------------------------------------+");

        for (Student student : students) {
            System.out.printf("| %-4d | %-15s | %-15s | %-10s | %-4.1f |\n",
                    student.getSid(), student.getLastName(), student.getFirstName(), student.getMajor(), student.getGpa());
        }

        System.out.println("+--------------------------------------------------------------+");
    }

    public void sortStudentsByFirstName() {
        students.sort(Comparator.comparing(Student::getFirstName));
        System.out.println("Students sorted by first name.");
    }

    public void sortStudentsByLastName() {
        students.sort(Comparator.comparing(Student::getLastName));
        System.out.println("Students sorted by last name.");
    }

    public void sortStudentsBySID() {
        students.sort(Comparator.comparing(Student::getSid));
        System.out.println("Students sorted by SID.");
    }

    public void sortStudentsByGPA() {
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("Students sorted by GPA.");
    }

    public void findStudentWithHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student highestGPAStudent = Collections.max(students, Comparator.comparingDouble(Student::getGpa));

        System.out.println("+--------------------------------------------------------------+");
        System.out.printf("| %-4s | %-15s | %-15s | %-10s | %-4s |\n", "SID", "LAST NAME", "FIRST NAME", "MAJOR", "GPA");
        System.out.println("+--------------------------------------------------------------+");

        System.out.printf("| %-4d | %-15s | %-15s | %-10s | %-4.1f |\n",
                highestGPAStudent.getSid(), highestGPAStudent.getLastName(), highestGPAStudent.getFirstName(), highestGPAStudent.getMajor(), highestGPAStudent.getGpa());

        System.out.println("+--------------------------------------------------------------+");
    }

    public boolean isStudentListEmpty() {
        return students.isEmpty();
    }
}
