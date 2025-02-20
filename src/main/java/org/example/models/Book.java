package org.example.models;

public class Book {
    private final String title;
    private int copies;

    public Book(String title, int copies) {
        this.title = title;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return copies > 0;
    }

    public void borrowBook() throws Exception {
        if (copies > 0) {
            copies--;
        } else {
            throw new Exception("Book taken");
        }
    }

    public void returnBook() {
        copies++;
    }
}

