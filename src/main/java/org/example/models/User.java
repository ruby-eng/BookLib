package org.example.models;

public abstract class User{
    protected String name;
    protected int priority;
    protected String requestedBook;  //so the  can be accessed b the child class
    public User(String name, int priority){
        this.name = name;
        this.priority = priority;
    }
    public String getName(){
        return name;
    }
    public int getPriority(){
        return priority;
    }
    public String getRequestedBook() {
        return requestedBook;
    }

    public void setRequestedBook(String requestedBook) {
        this.requestedBook = requestedBook;
    }
}
