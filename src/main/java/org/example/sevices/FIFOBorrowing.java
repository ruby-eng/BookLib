package org.example.sevices;

import org.example.models.Book;
import org.example.models.User;

import java.util.Map;
import java.util.Queue;

    public class FIFOBorrowing implements BorrowingStrategy {
        @Override
        public void processRequests(Queue<User> queue, Map<String, Book> books) {
            while (!queue.isEmpty()) {
                User user = queue.poll();
                Book book = books.get(user.getRequestedBook());

                if (book != null && book.isAvailable()) {
                    try {
                        book.borrowBook();
                        System.out.println(user.getName() + " borrowed " + book.getTitle());
                    } catch (Exception e) {
                        System.out.println(user.getName() + " could not borrow " + book.getTitle() + ": " + e.getMessage());
                    }
                }
            }
        }
    }


