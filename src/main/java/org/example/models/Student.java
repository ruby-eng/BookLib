
package org.example.models;

public class Student extends User {
    public Student(String name, int year) {
        super(name, 100 - year); // Higher year = higher priority (Lower number)
    }
}
