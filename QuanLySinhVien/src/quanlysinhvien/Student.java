/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

/**
 *
 * @author TTH1206
 */
class Student {

    private int sid;
    private String lastName;
    private String firstName;
    private String major;
    private double gpa;

    public Student(int sid, String lastName, String firstName, String major, double gpa) {
        this.sid = sid;
        this.lastName = lastName;
        this.firstName = firstName;
        this.major = major;
        this.gpa = gpa;
    }

    public int getSid() {
        return sid;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return "SID: " + sid + ", Name: " + firstName + " " + lastName + ", Major: " + major + ", GPA: " + gpa;
    }
}
