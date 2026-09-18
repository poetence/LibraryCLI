package org.example;

import java.util.Objects;

public class Book{
    Book(String isbn, String title, String author){
        this.checkedOut = false;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    private final String isbn;
    private final String title;
    private final String author;
    private boolean checkedOut;
    /*Getters to return class info */
    public boolean isCheckedOut() {
        return checkedOut;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    /* A setter to affect our only mutable variable (CheckedOut)*/
    void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    @Override
    public String toString() {
        return (title + ", by " + author + ", isbn: " + isbn);
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book other = (Book) o;
        return this.isbn.equals(other.getIsbn());
    }
    @Override
    public int hashCode(){
        return Objects.hash(isbn);
    }
}
