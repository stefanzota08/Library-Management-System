package Library;

import java.util.Date;

public class Book implements Comparable{
    protected String bookName;
    protected String authorFirstName;
    protected String authorLastName;
    protected Date publishDate;

    public Book (String _bookName, String _authorFirstName, String _authorLastName, Date _publishDate){
        bookName = _bookName;
        authorFirstName = _authorFirstName;
        authorLastName = _authorLastName;
        publishDate = _publishDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorName(String authorFirstName, String authorLastName) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    @Override
    public int compareTo(Object o) {
        Book tmp = ((Book) o);

        if ( bookName.equals(tmp.bookName))
            return authorLastName.compareTo(tmp.authorLastName);
        return bookName.compareTo(tmp.bookName);
    }

    @Override
    public String toString() {
        return bookName + " scrisa de " + authorFirstName + " " + authorLastName + " ";
    }
}