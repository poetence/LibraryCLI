package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Library library = new Library();
            Book effectiveJava = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
            Book headFirstDesignPatterns = new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman");
            Member alice =  new Member("Alice Chen", "M001");
            Member marcus = new Member("Marcus Reid", "M002");
            library.addBook(effectiveJava);
            library.addBook(headFirstDesignPatterns);
            library.registerMember(alice);
            library.registerMember(marcus);
            System.out.println(library.getAvailableBooks());
            library.checkOut("978-0134685991", "M001");
            try{
                library.checkOut("978-0134685991", "M002");
            } catch(IllegalStateException e){
                System.out.println(e.getMessage());
            }
            library.returnBook("978-0134685991", "M001");
            System.out.println(library.getAvailableBooks());
            library.checkOut("978-0596009205", "M002");
            System.out.println(library.getAvailableBooks());


    }
}

