package com.elemica.supply.assignmentThree;


import java.util.*;

public final class FamilyTreeManager {
    private Map<String, Person> idToPerson = new HashMap<>();
    private Map<Person, Set<Person>> parentsMap = new HashMap<>();
    private Map<Person, Set<Person>> childrenMap = new HashMap<>();

    public void createPerson(String id, String name) throws Exception {
        if (idToPerson.containsKey(id)) {
            throw new Exception("This ID already exists.");
        }
        Person person = new Person(id, name);
        idToPerson.put(id, person);
        parentsMap.put(person, new HashSet<>());
        childrenMap.put(person, new HashSet<>());
    }

    public void addRelation(String parentId, String childId) throws Exception {
        Person parent = idToPerson.get(parentId);
        Person child = idToPerson.get(childId);

        if (parent == null) throw new Exception("Parent not found.");
        if (child == null) throw new Exception("Child not found.");

        if (createsCycle(parent, child)) {
            throw new Exception("Adding this relation would create a cycle.");
        }

        childrenMap.get(parent).add(child);
        parentsMap.get(child).add(parent);
    }

    public void removeRelation(String parentId, String childId) throws Exception {
        Person parent = idToPerson.get(parentId);
        Person child = idToPerson.get(childId);

        if (parent != null && child != null) {
            childrenMap.getOrDefault(parent, Collections.emptySet()).remove(child);
            parentsMap.getOrDefault(child, Collections.emptySet()).remove(parent);
        }
    }

    public void printParents(String childId) throws Exception {
        Person child = idToPerson.get(childId);
        if (child == null) throw new Exception("Child not found.");

        Set<Person> parents = parentsMap.getOrDefault(child, Collections.emptySet());
        if (parents.isEmpty()) {
            System.out.println("No parents found.");
        } else {
            for (Person p : parents) {
                System.out.println("Parent: " + p.getIdentifier() + " - " + p.getFullName());
            }
        }
    }

    public void printChildren(String parentId) throws Exception {
        Person parent = idToPerson.get(parentId);
        if (parent == null) throw new Exception("Parent not found.");

        Set<Person> children = childrenMap.getOrDefault(parent, Collections.emptySet());
        if (children.isEmpty()) {
            System.out.println("No children found.");
        } else {
            for (Person c : children) {
                System.out.println("Child: " + c.getIdentifier() + " - " + c.getFullName());
            }
        }
    }

    public void printAllAncestors(String personId) throws Exception {
        Person person = idToPerson.get(personId);
        if (person == null) throw new Exception("Person not found.");

        System.out.println("Ancestors of " + person.getFullName() + ":");
        Set<Person> visited = new HashSet<>();
        printAncestorsRecursive(person, visited);
    }

    private void printAncestorsRecursive(Person current, Set<Person> visited) {
        if (visited.contains(current)) return;
        visited.add(current);

        for (Person parent : parentsMap.getOrDefault(current, Collections.emptySet())) {
            System.out.println(parent.getIdentifier() + " - " + parent.getFullName());
            printAncestorsRecursive(parent, visited);
        }
    }

    public void printAllDescendants(String personId) throws Exception {
        Person person = idToPerson.get(personId);
        if (person == null) throw new Exception("Person not found.");

        System.out.println("Descendants of " + person.getFullName() + ":");
        Set<Person> visited = new HashSet<>();
        printDescendantsRecursive(person, visited);
    }

    private void printDescendantsRecursive(Person current, Set<Person> visited) {
        if (visited.contains(current)) return;
        visited.add(current);

        for (Person child : childrenMap.getOrDefault(current, Collections.emptySet())) {
            System.out.println(child.getIdentifier() + " - " + child.getFullName());
            printDescendantsRecursive(child, visited);
        }
    }

    private boolean createsCycle(Person proposedParent, Person proposedChild) {
        return isDescendant(proposedChild, proposedParent, new HashSet<>());
    }

    private boolean isDescendant(Person start, Person target, Set<Person> visited) {
        if (start.equals(target)) return true;
        if (!visited.add(start)) return false;

        for (Person child : childrenMap.getOrDefault(start, Collections.emptySet())) {
            if (isDescendant(child, target, visited)) return true;
        }
        return false;
    }
}

