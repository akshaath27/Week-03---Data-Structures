import java.util.Scanner;

// Node class representing a student
class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Linked List Class
class StudentLinkedList {
    private Student head;

    // Add at the beginning
    public void addAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at the end
    public void addAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at a specific position (1-based index)
    public void addAtPosition(int position, int roll, String name, int age, String grade) {
        if (position <= 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        Student newNode = new Student(roll, name, age, grade);
        Student temp = head;

        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds, adding at end.");
            addAtEnd(roll, name, age, grade);
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by roll number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }

        Student prev = null;
        Student curr = head;

        while (curr != null && curr.rollNumber != roll) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Record not found.");
            return;
        }

        prev.next = curr.next;
        System.out.println("Record deleted.");
    }

    // Search by roll number
    public void searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Found: " + temp.rollNumber + ", " + temp.name + ", " + temp.age + ", " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade by roll number
    public void updateGrade(int roll, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }
        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

// Main class
class StudentRecordManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.print("Enter Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Grade: ");
                String grade = sc.nextLine();

                if (choice == 1)
                    list.addAtBeginning(roll, name, age, grade);
                else if (choice == 2)
                    list.addAtEnd(roll, name, age, grade);
                else {
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(pos, roll, name, age, grade);
                }
            } else if (choice == 4) {
                System.out.print("Enter Roll Number to delete: ");
                list.deleteByRollNumber(sc.nextInt());
            } else if (choice == 5) {
                System.out.print("Enter Roll Number to search: ");
                list.searchByRollNumber(sc.nextInt());
            } else if (choice == 6) {
                System.out.print("Enter Roll Number to update: ");
                int r = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new Grade: ");
                String newG = sc.nextLine();
                list.updateGrade(r, newG);
            } else if (choice == 7) {
                list.displayAll();
            } else if (choice == 0) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
