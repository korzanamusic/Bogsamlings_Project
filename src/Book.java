public class Book {
    //ATTRIBUTTER
    private String title;
    private String author;
    private int publicationYear;
    private boolean read = false;
    private Genres genre;

    //KONSTRUKTOR
    public Book(String title, String author, int publicationYear, boolean read, Genres genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.read = read;
        this.genre = genre;
    }

    // GETTERS
    public String getTitle() {
        return title;
    }

    public Genres getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isRead() {
        return read;
    }


    //METODER
    public void printInfo() {
        System.out.println(this.getTitle() + "\n" + this.getAuthor() + "\n" + this.getPublicationYear() + "\nLæst: " + this.isRead() + "\nGenre: " + this.getGenre() + "\n" + "Er klassisk: " + isClassic(2026) + "\n");
    }

    public void markAsRead() {
        this.read = true;
    }

    public void markAsUnRead() {
        this.read = false;
    }

    public boolean isClassic(int currentYear) {
        if (publicationYear <= currentYear - 20) {
            return true;
        } else {
            return false;
        }
    }
}
