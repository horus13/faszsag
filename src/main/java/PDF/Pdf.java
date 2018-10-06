package PDF;

public class Pdf {

    Long books;
    String title;
    String author;
    String file;

    public Long getBooks() {
        return books;
    }

    public void setBooks(Long books) {
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }





    @Override
    public String toString() {
        return "Pdf{" +
                "books=" + books +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
