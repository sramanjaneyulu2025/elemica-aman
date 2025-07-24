package com.elemica.supply.chain.officialAssign02;

import java.util.*;

public class StudentRepository {
    private final TreeSet<Student> studentSet = new TreeSet<>();

    public void load(List<Student> students) {
        studentSet.clear();
        studentSet.addAll(students);
    }

    public boolean add(Student student) {
        return studentSet.add(student);
    }

    public boolean deleteByRollNumber(int rollNumber) {
        return studentSet.removeIf(s -> s.getRollNumber() == rollNumber);
    }

    public boolean existsRollNumber(int rollNumber) {
        return studentSet.stream().anyMatch(s -> s.getRollNumber() == rollNumber);
    }

    public List<Student> getAll() {
        return new ArrayList<>(studentSet);
    }
}

