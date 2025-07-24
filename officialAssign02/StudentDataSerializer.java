package com.elemica.supply.chain.officialAssign02;

import java.io.*;
import java.util.List;

public class StudentDataSerializer {
    private static final String FILE = "students.ser";

    public static void save(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(students);
            System.out.println("✅ Data saved successfully.");
        } catch (IOException e) {
            System.err.println("❌ Error saving data: " + e.getMessage());
        }
    }

    public static List<Student> load() {
        File file = new File(FILE);
        if (!file.exists()) return List.of();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Student>) ois.readObject();
        } catch (Exception e) {
            System.err.println("⚠️ Could not load data: " + e.getMessage());
            return List.of();
        }
    }
}
