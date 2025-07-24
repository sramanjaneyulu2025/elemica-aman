package com.elemica.supply.chain.officialAssign02;

public enum Course {
    A, B, C, D, E, F;

    public static boolean isValid(String name) {
        try {
            Course.valueOf(name.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

