package com.elemica.supply.chain.officialAssign02;

import java.util.Comparator;

public class StudentComparatorFactory {
    public static Comparator<Student> getComparator(String field, boolean ascending) {
        Comparator<Student> comparator;

        switch (field.toLowerCase()) {
            case "roll":
                comparator = Comparator.comparingInt(Student::getRollNumber);
                break;
            case "age":
                comparator = Comparator.comparingInt(Student::getAge);
                break;
            case "address":
                comparator = Comparator.comparing(Student::getAddress, String.CASE_INSENSITIVE_ORDER);
                break;
            case "name":
            default:
                comparator = Comparator.comparing(Student::getFullName, String.CASE_INSENSITIVE_ORDER);
        }

        return ascending ? comparator : comparator.reversed();
    }
}

