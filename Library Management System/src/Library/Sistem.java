package Library;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Library.AllCategories.Thriller;

public class Sistem {

    Sistem() {}

    public void menu() {
        Book book;
        String bookName;
        String authorFirstName;
        String authorLastName;
        Date publishDate;
        List<Section> sectiuni = new ArrayList<>();
        List<Author> autori = new ArrayList<>();
        List<Book> carti = new ArrayList<>();
        Author author;
        String firstName;
        String lastName;

        int choice;
        int id;

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Choose an option:");
            System.out.println("1) Add a new book");
            System.out.println("2) See all books in a section");
            System.out.println("3) See the books written by an author");
            System.out.println("4) See all the authors in the library");
            System.out.println("5) See all the books in the library");
            System.out.println("6) Edit a book info");
            System.out.println("7) Edit author name");
            System.out.println("8) Exit");

            System.out.println("\nEnter your option: ");
            choice = scanner.nextInt();

            //System.out.println(chosen);
            try {
                switch (choice) {
                    case 1:
                        System.out.println("     ----- Add a new book -----");
                        System.out.println("Enter the name of the book");
                        bookName = scanner.next();
                        System.out.println("Enter the name of the author");
                        authorFirstName = scanner.next();
                        authorLastName = scanner.next();
                        System.out.println("Enter the publish date of the book");
                        publishDate = new Date(scanner.next());
                        Book _book = new Book(bookName, authorFirstName, authorLastName, publishDate);
                        Author _author = new Author(authorFirstName, authorLastName);
                        _author.addBook(_book);
                        autori.add(_author);
                        carti.add(_book);
                        System.out.println("Select the category of the book: ");
                        System.out.println("1) Thriller");
                        System.out.println("2) Actiune");
                        System.out.println("3) Aventura");
                        System.out.println("4) Istorie");
                        System.out.println("5) Fictiune");
                        System.out.println("6) Dragoste");
                        System.out.println("Enter the number of the category: ");
                        id = scanner.nextBigDecimal().intValue();
                        boolean ok = false;
//                        Category category = new Category(_book, AllCategories.values()[id]);
                        if (sectiuni.size() > 0){
                            for (Section _section : sectiuni)
                                if(_section.getSectionName() == AllCategories.values()[id]){
                                    _section.addBook(_book);
                                    ok = true;
                                    break;
                                }
                        }
                        if(!ok){
                            Section section = new Section(AllCategories.values()[id-1], id);
                            section.addBook(_book);
                            sectiuni.add(section);
                        }

                        break;

                    case 2:
                        System.out.println("     ----- Select the section you want to see -----");

                        System.out.println("1) Thriller");
                        System.out.println("2) Actiune");
                        System.out.println("3) Aventura");
                        System.out.println("4) Istorie");
                        System.out.println("5) Fictiune");
                        System.out.println("6) Dragoste");
                        System.out.println("Enter the number of the category: ");
                        id = scanner.nextBigDecimal().intValue();
                        ok = false;
                        if(sectiuni.size() == 0)
                            System.out.println("Nu ati creat nicio sectiune inca!");
                        else{
                            for (Section _section : sectiuni)
                                if(_section.getSectionId() == id){
                                    ok = true;
                                    _section.showBooks();
                                }
                        }
                        if(!ok)
                            System.out.println("Nu exista nicio carte in sectiunea aleasa!");

                        break;

                    case 3:
                        System.out.println("     -----Write the name of the author-----");
                        System.out.println("Enter the Author's Name:");
                        String first = scanner.next();
                        String last = scanner.next();
                        for (Author __author : autori)
                            if (__author.getFirstName().equals(first) && __author.getLastName().equals(last))
                                __author.showBooks();
                        break;

                    case 4:
                        System.out.println("The authors with books in this library are:\n ");
                        for (Author a : autori)
                            System.out.println(a);
                        break;

                    case 5:
                        System.out.println("The list of books in this library is: \n");
                        for (Book b : carti)
                            System.out.println(b);
                        break;

                    case 6:
                        int idBook;
                        boolean exista = false;
                        System.out.println("What book are you looking for?");
                        System.out.println("Enter book's name: ");
                        String _bookName = scanner.next();
                        for (Book b : carti)
                            if (b.getBookName().equals(_bookName)){
                                exista = true;
                                break;
                            }
                        if(!exista)
                            System.out.println("The book you enter does not exist! Try Again...");
                        else{

                            System.out.println("Choose Action:");
                            System.out.println("1) Change Book Name");
                            System.out.println("2) Change Book's Author");
                            id = scanner.nextBigDecimal().intValue();

                                switch (id) {
                                    case 1:
                                        System.out.println("Enter New Name: ");
                                        String __bookName = scanner.next();
                                        System.out.println("Are you sure you want to change the name to " + __bookName + " ? (y/n)");
                                        if (scanner.next().equals("y") || scanner.next().equals("Y"))
                                            for (Book b : carti)
                                                if (b.getBookName().equals(_bookName))
                                                    b.setBookName(__bookName);
                                        break;
                                    case 2:
                                        System.out.println("Enter New Author Name ( first name + last name ): ");
                                        String _first = scanner.next();
                                        String _last = scanner.next();
                                        String f = "";
                                        String l = "";
                                        System.out.println("Are you sure you want to change the author to " + _first + " " + _last + " ? (y/n)");
                                        if (scanner.next().equals("y") || scanner.next().equals("Y"))
                                            for (Book b : carti)
                                                if (b.getBookName().equals(_bookName)){
                                                    f = b.getAuthorFirstName();
                                                    l = b.getAuthorLastName();
                                                    b.setAuthorName(_first, _last);}
                                            for(Author a: autori)
                                                if(a.getFirstName().equals(f) && a.getLastName().equals(l)){
                                                    a.setFirstName(_first);
                                                    a.setLastName(_last);
                                                }
                                        break;

                                }
                            }
                        break;
                    case 7:
                        exista = false;
                        System.out.println("What author are you looking for?");
                        System.out.println("Enter author's name: ");
                        String _authorFirstName = scanner.next();
                        String _authorLastName = scanner.next();
                        for (Author a : autori)
                            if (a.getFirstName().equals(_authorFirstName) && a.getLastName().equals(_authorLastName)){
                                exista = true;
                                break;
                            }
                        if(!exista)
                            System.out.println("The author you enter does not exist! Try Again...");
                        else {
                            System.out.println("Enter a New Name for the author (first name + last name): ");
                            _authorFirstName = scanner.next();
                            _authorLastName = scanner.next();
                            System.out.println("Are you sure you want to change the name to -> " + _authorFirstName + " " + _authorLastName + " ? (y/n)");
                            if (scanner.next().equals("y") || scanner.next().equals("Y")){
                                for (Author a : autori)
                                    if (a.getFirstName().equals(_authorFirstName) && a.getLastName().equals(_authorLastName)){
                                        a.setFirstName(_authorFirstName);
                                        a.setLastName(_authorLastName);
                                    }
                                for (Book b : carti)
                                    if (b.getAuthorFirstName().equals(_authorFirstName) && b.getAuthorLastName().equals(_authorLastName)){
                                        b.setAuthorName(_authorFirstName, _authorLastName);
                                    }
                            }
                        }
                        break;
                    case 8:
                        loop = false;
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, try again");
            }

        }
    }
}
