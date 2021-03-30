package Library;

import java.util.*;
import java.lang.Object;

enum AllCategories {
    Thriller,
    Actiune,
    Aventura,
    Istorie,
    Fictiune,
    Dragoste
}

public class Section {  // un obiect care retine toate cartile dintr-o categorie
    private AllCategories sectionName;
    private Integer sectionId;
    public ArrayList<Book> books;  // lista cartilor dintr-o categorie

    public Section(AllCategories _sectionName, Integer _sectionId) {
        books = new ArrayList<>();
        sectionName = _sectionName;
        sectionId = _sectionId;
    }

    public AllCategories getSectionName() {
        return sectionName;
    }

    public void setSectionName(AllCategories sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public void addBook(Book _book) {
        books.add(_book);
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public String toString() {
        return "Categoria: " + sectionId + " = " + sectionName;
    }
}