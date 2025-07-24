package com.elemica.supply.chain.officialAssign02;

import java.util.Set;

public class StudentInputValidator {
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }

    public static boolean isValidAge(String ageStr) {
        try {
            return Integer.parseInt(ageStr) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidRollNumber(String rollStr) {
        try {
            Integer.parseInt(rollStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidCourseSet(Set<String> courses) {
        return courses.size() == 4 && courses.stream().allMatch(Course::isValid);
    }
}
