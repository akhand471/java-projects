import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isBorrowed;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    void borrow() {
        isBorrowed = true;
    }

    void returnBook() {
        isBorrowed = false;
    }

    public String toString() {
        return title + " by " + author + (isBorrowed ? " [Borrowed]" : " [Available]");
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("📚 Welcome to Library Management System");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> searchBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> {
                    System.out.println("👋 Exiting Library System. See you again!");
                    exit = true;
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        library.add(new Book(title, author));
        System.out.println("✅ Book added to library.");
    }

    static void viewBooks() {
        if (library.isEmpty()) {
            System.out.println("📭 No books in the library.");
        } else {
            System.out.println("\n📚 Library Books:");
            for (int i = 0; i < library.size(); i++) {
                System.out.println((i + 1) + ". " + library.get(i));
            }
        }
    }

    static void searchBook() {
        System.out.print("Enter book title to search: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : library) {
            if (book.title.toLowerCase().contains(keyword)) {
                System.out.println("🔍 Found: " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ No book found with that title.");
        }
    }

    static void borrowBook() {
        viewBooks();
        System.out.print("Enter book number to borrow: ");
        int index = sc.nextInt() - 1;

        if (isValidIndex(index)) {
            Book book = library.get(index);
            if (book.isBorrowed) {
                System.out.println("❌ Book is already borrowed.");
            } else {
                book.borrow();
                System.out.println("✅ You borrowed the book.");
            }
        } else {
            System.out.println("❌ Invalid book number.");
        }
    }

    static void returnBook() {
        viewBooks();
        System.out.print("Enter book number to return: ");
        int index = sc.nextInt() - 1;

        if (isValidIndex(index)) {
            Book book = library.get(index);
            if (!book.isBorrowed) {
                System.out.println("❌ Book is not currently borrowed.");
            } else {
                book.returnBook();
                System.out.println("✅ Book returned successfully.");
            }
        } else {
            System.out.println("❌ Invalid book number.");
        }
    }

    static void deleteBook() {
        viewBooks();
        System.out.print("Enter book number to delete: ");
        int index = sc.nextInt() - 1;

        if (isValidIndex(index)) {
            library.remove(index);
            System.out.println("🗑 Book deleted.");
        } else {
            System.out.println("❌ Invalid book number.");
        }
    }

    static boolean isValidIndex(int index) {
        return index >= 0 && index < library.size();
    }
}
