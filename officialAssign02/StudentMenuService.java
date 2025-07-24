package com.elemica.supply.chain.officialAssign02;

import java.util.*;

public class StudentMenuService {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentRepository repository;

    public StudentMenuService(StudentRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n📘 Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Save");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> displayStudents();
                case "3" -> deleteStudent();
                case "4" -> {
                    StudentDataSerializer.save(repository.getAll());
                    System.out.println("📥 Data saved successfully.");
                }
                case "5" -> {
                    exitPrompt();
                    return;
                }
                default -> System.out.println("❌ Invalid input. Please choose 1-5.");
            }
        }
    }

    private void addStudent() {
        try {
            System.out.print("Full Name: ");
            String name = scanner.nextLine().trim();
            if (!StudentInputValidator.isValidName(name))
                throw new Exception("Invalid name.");

            System.out.print("Age: ");
            String ageStr = scanner.nextLine().trim();
            if (!StudentInputValidator.isValidAge(ageStr))
                throw new Exception("Invalid age.");
            int age = Integer.parseInt(ageStr);

            System.out.print("Address: ");
            String address = scanner.nextLine().trim();
            if (!StudentInputValidator.isValidAddress(address))
                throw new Exception("Invalid address.");

            System.out.print("Roll Number: ");
            String rollStr = scanner.nextLine().trim();
            if (!StudentInputValidator.isValidRollNumber(rollStr))
                throw new Exception("Invalid roll number.");
            int roll = Integer.parseInt(rollStr);

            if (repository.existsRollNumber(roll))
                throw new Exception("Roll number already exists.");

            Set<String> courses = new HashSet<>();
            System.out.println("Select exactly 4 different courses (A–F).");
            while (courses.size() < 4) {
                System.out.print("Enter course " + (courses.size() + 1) + ": ");
                String course = scanner.nextLine().trim().toUpperCase();
                if (Course.isValid(course) && !courses.contains(course)) {
                    courses.add(course);
                } else {
                    System.out.println("❌ Invalid or duplicate course. Pick from A, B, C, D, E, F.");
                }
            }

            Student student = new Student(name, age, address, roll, courses);
            repository.add(student);
            System.out.println("✅ Student added successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void displayStudents() {
        List<Student> all = repository.getAll();
        if (all.isEmpty()) {
            System.out.println("📭 No records found.");
            return;
        }

        System.out.print("Sort by (name/roll/age/address): ");
        String field = scanner.nextLine().trim();

        System.out.print("Order (asc/desc): ");
        boolean asc = scanner.nextLine().trim().equalsIgnoreCase("asc");

        List<Student> sorted = all.stream()
                .sorted(StudentComparatorFactory.getComparator(field, asc))
                .toList();

        System.out.printf("\n%-20s %-10s %-5s %-20s %-20s\n", "Name", "Roll", "Age", "Address", "Courses");
        System.out.println("---------------------------------------------------------------------------------------");
        for (Student s : sorted) {
            System.out.printf("%-20s %-10d %-5d %-20s %-20s\n",
                    s.getFullName(),
                    s.getRollNumber(),
                    s.getAge(),
                    s.getAddress(),
                    String.join(", ", s.getCourses()));
        }
    }

    private void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        String input = scanner.nextLine().trim();
        if (!StudentInputValidator.isValidRollNumber(input)) {
            System.out.println("❌ Invalid roll number.");
            return;
        }

        int roll = Integer.parseInt(input);
        if (repository.deleteByRollNumber(roll)) {
            System.out.println("✅ Student with roll " + roll + " deleted.");
        } else {
            System.out.println("❌ Roll number " + roll + " not found.");
        }
    }

    private void exitPrompt() {
        System.out.print("Do you want to save changes before exiting? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            StudentDataSerializer.save(repository.getAll());
            System.out.println("📥 Data saved successfully.");
        }
        System.out.println("👋 Exiting application. Goodbye!");
    }
}
