package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(false);
        library.addBook("Java Programming", 4);
        User teacher = new Teacher("Mr. Smith");
        User seniorStudent = new Student("John", 3);
        User juniorStudent = new Student("Alice", 1);
        library.requestBook(seniorStudent, "Java Programming");
        library.requestBook(teacher, "Java Programming");
        library.requestBook(juniorStudent, "Java Programming");
        library.processRequests();
    }
}


