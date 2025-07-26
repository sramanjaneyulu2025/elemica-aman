package com.elemica.supply.assignmentThree;


import java.util.Scanner;

public class FamilyApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FamilyTreeManager familyManager = new FamilyTreeManager();
        boolean active = true;

        while (active) {
            try {
                System.out.println("\nChoose an option:");
                System.out.println("1 - Register a Person");
                System.out.println("2 - Add Parent-Child Relation");
                System.out.println("3 - Remove Relation");
                System.out.println("4 - List Parents");
                System.out.println("5 - List Children");
                System.out.println("6 - Show Ancestors");
                System.out.println("7 - Show Descendants");
                System.out.println("0 - Exit");
                System.out.print("Your choice: ");

                String input = scanner.nextLine().trim();

                switch (input) {
                    case "1":
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine().trim();
                        familyManager.createPerson(id, name);
                        System.out.println("Person created!");
                        break;

                    case "2":
                        System.out.print("Parent ID: ");
                        String parentId = scanner.nextLine().trim();
                        System.out.print("Child ID: ");
                        String childId = scanner.nextLine().trim();
                        familyManager.addRelation(parentId, childId);
                        System.out.println("Relation added!");
                        break;

                    case "3":
                        System.out.print("Parent ID to remove: ");
                        String pId = scanner.nextLine().trim();
                        System.out.print("Child ID to remove: ");
                        String cId = scanner.nextLine().trim();
                        familyManager.removeRelation(pId, cId);
                        System.out.println("Relation removed (if existed).");
                        break;

                    case "4":
                        System.out.print("Child's ID: ");
                        String childToFind = scanner.nextLine().trim();
                        familyManager.printParents(childToFind);
                        break;

                    case "5":
                        System.out.print("Parent's ID: ");
                        String parentToFind = scanner.nextLine().trim();
                        familyManager.printChildren(parentToFind);
                        break;

                    case "6":
                        System.out.print("Person ID to see ancestors: ");
                        String ancestorId = scanner.nextLine().trim();
                        familyManager.printAllAncestors(ancestorId);
                        break;

                    case "7":
                        System.out.print("Person ID to see descendants: ");
                        String descendantId = scanner.nextLine().trim();
                        familyManager.printAllDescendants(descendantId);
                        break;

                    case "0":
                        active = false;
                        System.out.println("Thank you for using the app!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
