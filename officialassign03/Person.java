package com.elemica.supply.assignmentThree;


import java.util.HashMap;
import java.util.Map;

public class Person {
    private String identifier;
    private String fullName;
    private Map<String, String> attributes = new HashMap<>();

    public Person(String identifier, String fullName) throws Exception {
        validate(identifier, fullName);
        this.identifier = identifier;
        this.fullName = fullName;
    }

    private void validate(String id, String name) throws Exception {
        if (id == null || id.trim().isEmpty())
            throw new Exception("Identifier cannot be empty.");

        if (name == null || name.trim().isEmpty())
            throw new Exception("Full name cannot be empty.");

        if (!id.matches("[a-zA-Z0-9 ]+"))
            throw new Exception("Identifier must contain only letters, digits, or spaces.");

        if (!name.matches("[a-zA-Z ]+"))
            throw new Exception("Full name must contain only letters and spaces.");
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getFullName() {
        return fullName;
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }
}
