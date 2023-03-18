package Lab5;

import java.util.*;
import java.util.Scanner;

class Lab5 {
    private int regNo;
    private String name;
    private String email;
    private String phone;
    private String className;
    private String department;

    public Lab5(int regNo, String name, String email, String phone, String className, String department) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.className = className;
        this.department = department;
    }

    public void printDetails() {
        System.out.println("Reg. No.: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + className);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lab5[] students = new Lab5[100];
        int count = 0;
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Reg. No.: ");
                    int regNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Class: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    students[count++] = new Lab5(regNo, name, email, phone, className, department);
                    break;
                case 2:
                    System.out.println("Search for a student:");
                    System.out.println("1. Search by Reg. No.");
                    System.out.println("2. Search by Name");
                    System.out.print("Enter your choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter Reg. No.: ");
                            int searchRegNo = scanner.nextInt();
                            for (int i = 0; i < count; i++) {
                                if (students[i].regNo == searchRegNo) {
                                    students[i].printDetails();
                                    found = true;
                                    break;
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Enter Name: ");
                            String searchName = scanner.nextLine();
                            for (int i = 0; i < count; i++) {
                                if (students[i].name.equals(searchName)) {
                                    students[i].printDetails();
                                    found = true;
                                }
                            }
                            break;
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    for (int i = 0; i < count; i++) {
                        students[i].printDetails();
                        System.out.println();
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }
}
