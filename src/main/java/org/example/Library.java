package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> catalog;
    private final Map<String, Member> members;
    public Library() {
        this.catalog = new ArrayList<Book>();
        this.members = new HashMap<String, Member>();
    }
    public void addBook(Book book) {
        this.catalog.add(book);
    }
    public void registerMember(Member member) {
        this.members.put(member.getMemberId(), member);
    }
    public void checkOut(String isbn, String memberId) {
        Optional<Book> book = catalog.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
        boolean memberExists = members.containsKey(memberId);
        if (!memberExists || !book.isPresent()){
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist or memberId " + memberId + "does not exist");
        } else if (book.get().isCheckedOut()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is already checkedOut");
        } else {
            book.get().setCheckedOut(true);
            Member member = members.get(memberId);
            member.addBorrowedBooks(book.get());
        }
    }
    public void returnBook(String isbn, String memberId) {
        Optional<Book> book = catalog.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
        boolean memberExists = members.containsKey(memberId);
        if (!memberExists || !book.isPresent()){
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist or memberId " + memberId + "does not exist");
        } else if (!book.get().isCheckedOut()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is not checkedOut");
        } else {
            book.get().setCheckedOut(false);
            Member member = members.get(memberId);
            member.removeBorrowedBooks(book.get());
        }
    }
    public List<Book> getAvailableBooks() {
        return catalog.stream().filter(b -> !b.isCheckedOut()).toList();
    }
}
