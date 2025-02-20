package org.example.sevices;

import org.example.models.Book;
import org.example.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

    public class LibraryService {
        private Map<String, Book> books = new HashMap<>();
        private Queue<User> borrowQueue;
        private BorrowingStrategy borrowingStrategy;

        public LibraryService(BorrowingStrategy borrowingStrategy) {
            this.borrowingStrategy = borrowingStrategy;
            this.borrowQueue = new PriorityQueue<>((u1, u2) -> Integer.compare(u1.getPriority(), u2.getPriority()));
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
            borrowQueue.add(user);
        }

        public void processRequests() {
            borrowingStrategy.processRequests(borrowQueue, books);
        }
    }


