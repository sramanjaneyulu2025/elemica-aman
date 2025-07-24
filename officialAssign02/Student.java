package com.elemica.supply.chain.officialAssign02;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Student implements Serializable, Comparable<Student> {
    private String fullName;
    private int age;
    private String address;
    private int rollNumber;
    private Set<String> courses;

    public Student(String fullName, int age, String address, int rollNumber, Set<String> courses) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        this.courses = new TreeSet<>(courses);
    }

    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    public int getRollNumber() { return rollNumber; }
    public Set<String> getCourses() { return courses; }

    @Override
    public int compareTo(Student other) {
        int nameCompare = this.fullName.compareToIgnoreCase(other.fullName);
        return nameCompare == 0 ? Integer.compare(this.rollNumber, other.rollNumber) : nameCompare;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10d %-5d %-20s %-20s",
                fullName, rollNumber, age, address, String.join(", ", courses));
    }
}
