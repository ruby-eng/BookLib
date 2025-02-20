package org.example.sevices;

import org.example.models.Book;
import org.example.models.User;

import java.util.Map;
import java.util.Queue;

    public interface BorrowingStrategy {
        void processRequests(Queue<User> queue, Map<String, Book> books);
    }


