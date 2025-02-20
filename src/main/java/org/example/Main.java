package org.example;

import org.example.models.Student;
import org.example.models.Teacher;
import org.example.models.User;
import org.example.sevices.LibraryService;
import org.example.sevices.PriorityBorrowing;

public class Main {
    public static void main(String[] args) {
        // Choose borrowing strategy (Change to new FIFOBorrowing() for FIFO)
        LibraryService library = new LibraryService(new PriorityBorrowing());

        library.addBook("Java Programming", 2);

        User teacher = new Teacher ("Mr. Smith");
        User seniorStudent = new Student("John", 3);
        User juniorStudent = new Student("Alice", 1);

        library.requestBook(seniorStudent, "Java Programming");
        library.requestBook(teacher, "Java Programming");
        library.requestBook(juniorStudent, "Java Programming");

        library.processRequests();
    }
}





