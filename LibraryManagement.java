import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            if (!scanner.hasNextLine()) {
                break; // in case input ends unexpectedly
            }
            input = scanner.nextLine().trim();
            if (input.equals("0")) {
                // command 0: end of program, no output
                break;
            }

            // Split the input by comma
            String[] parts = input.split(",", -1);
            int command = Integer.parseInt(parts[0]);

            switch (command) {
                case 1: {
                    // 1,bookName,authorName,year
                    String bookName = parts[1];
                    String authorName = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    books.add(new Book(bookName, authorName, year));
                    // no output
                    break;
                }
                case 2: {
                    // 2: print all books by year descending
                    List<Book> sorted = new ArrayList<>(books);
                    sorted.sort(Comparator.comparingInt(Book::getYear).reversed());
                    for (Book b : sorted) {
                        System.out.println(b);
                    }
                    break;
                }
                case 3: {
                    // 3: print all books by year ascending
                    List<Book> sorted = new ArrayList<>(books);
                    sorted.sort(Comparator.comparingInt(Book::getYear));
                    for (Book b : sorted) {
                        System.out.println(b);
                    }
                    break;
                }
                case 4: {
                    // 4,text : print books whose authorName contains text
                    String text = parts[1];
                    for (Book b : books) {
                        if (b.getAuthorName().contains(text)) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 5: {
                    // 5,text : print books whose bookName contains text
                    String text = parts[1];
                    for (Book b : books) {
                        if (b.getBookName().contains(text)) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 6: {
                    // 6,authorName : print number of books of this author
                    String authorName = parts[1];
                    int count = 0;
                    for (Book b : books) {
                        if (b.getAuthorName().equals(authorName)) {
                            count++;
                        }
                    }
                    System.out.println(count);
                    break;
                }
                case 7: {
                    // 7,n : print first n books in insertion order
                    int n = Integer.parseInt(parts[1]);
                    int limit = Math.min(n, books.size());
                    for (int i = 0; i < limit; i++) {
                        System.out.println(books.get(i));
                    }
                    break;
                }
                case 8: {
                    // 8 : print first book in insertion order
                    if (!books.isEmpty()) {
                        System.out.println(books.get(0));
                    }
                    break;
                }
                case 9: {
                    // 9 : print last book in insertion order
                    if (!books.isEmpty()) {
                        System.out.println(books.get(books.size() - 1));
                    }
                    break;
                }
                default:
                    // Unknown command; do nothing
                    break;
            }

        } while (true);

        scanner.close();
    }
}

class Book {
    private String bookName;
    private String authorName;
    private int year;

    public Book(String bookName, String authorName, int year) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return bookName + " written by " + authorName + " in " + year;
    }
}
