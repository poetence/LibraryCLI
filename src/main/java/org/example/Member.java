package org.example;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final String memberId;
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks =  new ArrayList<Book>();
    }
    private final List<Book> borrowedBooks;
    public List<Book> getBorrowedBooks() {
        return List.copyOf(borrowedBooks);
    }
    void addBorrowedBooks(Book book) {
        borrowedBooks.add(book);
    }
    void removeBorrowedBooks(Book book) {
        borrowedBooks.remove(book);
    }
    public String getName() {
        return name;
    }
    public String getMemberId() {
        return memberId;
    }
    @Override
    public String toString() {
        return name;
    }
}
