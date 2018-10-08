package PDF;

import java.sql.Blob;

public class Pdf {

    String id;
    String title;
    String author;
    Blob file;

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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






    @Override
    public String toString() {
        return "Pdf{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", fileName='" + file + '\'' +
                '}';
    }
}
