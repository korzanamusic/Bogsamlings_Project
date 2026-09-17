import java.util.ArrayList;

public class Library {

    // Attributer
    private String name;
    private ArrayList<Book> books;

    //Konstruktor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }


    // METODER
    public void addBook(Book book) {
        books.add(book);
    }

    public void printBooks() {
        for (int i = 0; i < books.size(); i++) {
            books.get(i).printInfo();
        }
    }

    public int getNumberOfBooks() {
        return books.size();
    }

    public void printUnreadBooks() {
        int booksUnread = 0;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isRead() == false) {
                book.printInfo();

                booksUnread++;
            }
        }
        if (booksUnread == 0) {
            System.out.println("Du har ingen ulæste bøger");
        }
    }

    public boolean removeBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equals(title)) {
                books.remove(i);
                return true;
            }

        }
        return false;
    }

    public int getNumberOfReadBooks() {
        int bookIsRead = 0;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isRead() == true) {
                bookIsRead++;
            }
        }
        if (bookIsRead > 0) {
            return bookIsRead;

        } else {
            System.out.println("Du har ingen læste bøger");
            return bookIsRead;
        }
    }

        public void printBooksByAuthor (String author){
           int  booksFound =0;
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    book.printInfo();
                    booksFound++;
                }

            }
            if(booksFound==0)
            {System.out.println("Ingen bøger blev fundet fra denne forfatter.");}
        }


        public Book findBookByTitle (String title){
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                if (book.getTitle().equals(title)) {
                    return book;
                }
            }
            return null;
        }


    }







