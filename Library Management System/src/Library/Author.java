package Library;
import java.util.*;

public class Author {
    protected String firstName;
    protected String lastName;
    protected Date dateOfBirth;
    public ArrayList<Book> books;

    public Author(String _firstName, String _lastName) {
        books = new ArrayList<>();
        firstName = _firstName;
        lastName = _lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void addBook(Book _book) {
        books.add(_book);
    }

    public void showBooks() {
        for (Book book : books)
            System.out.println(book);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}