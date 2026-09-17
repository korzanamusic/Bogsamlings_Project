import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        //BOOKS
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, false, Genres.FANTASY);
        Book book2 = new Book("Harry Potter og De Vises Sten", "J.K. Rowling", 1997, false, Genres.FANTASY);
        Book book3 = new Book("1984", "George Orwell", 1949, false, Genres.DYSTOPIA);


        // PUT IN LIBRARY
        Library library = new Library("Min BogSamling");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // METODE KALD

        // System.out.println("Antal bøger i dit bibliotek: " + library.getNumberOfBooks());

        //  boolean removed = library.removeBookByTitle("1983");

        //   if(removed)
        //   { System.out.println("Fjernet: " + removed);
        //   System.out.println("Antal bøger tilbage: " + library.getNumberOfBooks()); }
        //   else {System.out.println("Bogen blev ikke fundet.");


        // library.printUnreadBooks();

// Menu Kode
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Tilføj Bog." + "\n2. Vis alle bøger." + "\n3. Find Bog via title." + "\n4. Marker bog som læst." + "\n5. Marker bog som ulæst." + "\n6. Vis ulæste bøger." + "\n7. Vis bøger af specifik forfatter." + "\n8. Afslut.");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Skriv en titel: ");
                    String newBookTitle = scanner.nextLine();
                    System.out.println("Skriv en forfatter: ");
                    String newAuthor = scanner.nextLine();
                    System.out.println("Skriv året bogen kom ud: ");
                    int newPubYear = scanner.nextInt();
                    scanner.nextLine();
                    Genres newGenre = null;
                    while (newGenre == null) {
                        System.out.println("Vælg en genre (skriv et tal): " + "\n1. Fantasy." + "\n2. Crime" + "\n3. Science Fiction." + "\n4. History" + "\n5. Biography" + "\n6. Dystopia");
                        int genreChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (genreChoice) {
                            case 1:
                                newGenre = Genres.FANTASY;
                                break;
                            case 2:
                                newGenre = Genres.CRIME;
                                break;
                            case 3:
                                newGenre = Genres.SCIENCE_FICTION;
                                break;
                            case 4:
                                newGenre = Genres.HISTORY;
                                break;
                            case 5:
                                newGenre = Genres.BIOGRAPHY;
                                break;
                            case 6:
                                newGenre = Genres.DYSTOPIA;
                                break;
                            default:
                                System.out.println("Ugyldigt valg, prøv igen.");
                                break;
                        }

                    }
                    library.addBook(new Book(newBookTitle, newAuthor, newPubYear, false, newGenre));
                    break;

                case 2:
                    library.printBooks();
                    break;
                case 3:
                    System.out.println("Indtast bog title: ");
                    String title = scanner.nextLine();

                    Book foundBook = library.findBookByTitle(title);

                    if (foundBook != null) {
                        System.out.println("Bogen blev fundet: ");
                        foundBook.printInfo();
                    } else {
                        System.out.println("Bogen blev ikke fundet.");
                    }
                    break;
                case 4:
                    System.out.println("Vælg en bog.");
                    String valgtBog = scanner.nextLine();
                    Book bogTilLæst = library.findBookByTitle(valgtBog);

                    if (bogTilLæst != null) {
                        bogTilLæst.markAsRead();
                        System.out.println("Du har markeret \"" + valgtBog + "\" som læst.");
                    } else {
                        System.out.println("Bogen blev ikke fundet.");
                    }
                    break;

                case 5:
                    System.out.println("Vælg en bog.");
                    valgtBog = scanner.nextLine();
                    bogTilLæst = library.findBookByTitle(valgtBog);

                    if (bogTilLæst != null) {
                        bogTilLæst.markAsUnRead();
                        System.out.println("Du har markeret \"" + valgtBog + "\" som ikke læst.");
                    } else {
                        System.out.println("Bogen blev ikke fundet.");
                    }
                    break;

                case 6:
                    library.printUnreadBooks();


                case 7:
                    System.out.println("Indtast forfatter: ");
                    String author = scanner.nextLine();

                    library.printBooksByAuthor(author);

                    break;
            }
        }
        while (choice != 8);


        scanner.close();
    }

}



