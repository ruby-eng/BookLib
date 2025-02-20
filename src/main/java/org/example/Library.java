package org.example;

import java.util.*;

public class Library {
    private final boolean usePriority;
    private Map<String, Book> books = new HashMap<>();
    private Queue<User> borrowQueue = new LinkedList<>();
    private PriorityQueue<User> priorityQueue;
    public Library(boolean usePriority) {
        this.usePriority = usePriority;
        this.priorityQueue = new PriorityQueue<>((u1, u2) -> Integer.compare(u1.getPriority(), u2.getPriority()));
    }
    public void addBook(String title, int copies) {
        books.put(title, new Book(title, copies));
    }
    public void requestBook(User user, String title) {
        if (!books.containsKey(title)) {
            System.out.println("Book not found: " + title);
            return;
        }
        user.setRequestedBook(title);
        if (usePriority) {
            priorityQueue.add(user);
        } else {
            borrowQueue.add(user);
        }
    }
    public void processRequests() {
        Queue<User> queue = usePriority ? priorityQueue : borrowQueue;
        while (!queue.isEmpty()) {
            User user = queue.poll();
            String requestedTitle = user.getRequestedBook();
            Book book = books.get(requestedTitle);
            if (book != null && book.isAvailable()) {
                try {
                    book.borrowBook();
                    System.out.println(user.getName() + " borrowed " + book.getTitle());
                } catch (Exception e) {
                    System.out.println(user.getName() + " could not borrow " + book.getTitle() + ": " + e.getMessage());
                }
            } else {
                System.out.println(user.getName() + " could not borrow " + requestedTitle + ": Book taken");
            }
        }
    }


}

