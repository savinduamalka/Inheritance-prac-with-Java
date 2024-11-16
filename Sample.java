public class Sample {

    public static void main(String[] args) {
        Library l = new Library("Ape Pothhala", "Moratuwa");
        Book b1 = new Book("Super Man", "Hendry Frank", 750, 2012);
        Book b2 = new Book("Bat Man", "Thomas James", 1050, 2009);
        Book b3 = new Book("Monkey in the Jungle", "Steve Smith", 600, 2008);
        Ebook b4 = new Ebook("The Horse", "Rickey Huskey", 500, 2015, 45.0);

        Book[] books = { b1, b2, b3, b4 };

        System.out.println("Total number of books is: " + Book.getBookCount());
        System.out.println();

        for (Book b : books) {
            System.out.println("Book Information:");
            b.displayBookInfo();
            System.out.println("The price is: " + b.getDiscountedPrice());
            System.out.println("-----------------------------------");
        }

        l.showBooks(books);
    }
}

class Book {
    String title;
    String author;
    double price;
    int yearPublished;
    static int bookCount = 0;

    Book(String title, String author, double price, int yearPublished) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearPublished = yearPublished;
        bookCount++;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Year Published: " + yearPublished);
    }

    public double getDiscountedPrice() {
        if (yearPublished < 2010) {
            return price * 0.9;
        } else {
            return price;
        }
    }

    public static int getBookCount() {
        return bookCount;
    }
}

class Ebook extends Book {
    double fileSize;

    Ebook(String title, String author, double price, int yearPublished) {
        super(title, author, price, yearPublished);
        this.fileSize = 0;
        System.out.println("File size not provided; default set to 0 MB.");
    }

    Ebook(String title, String author, double price, int yearPublished, double fileSize) {
        super(title, author, price, yearPublished);
        this.fileSize = fileSize;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("File Size: " + fileSize + " MB");
    }
}

class Library {
    String libraryName;
    String location;

    Library(String libraryName, String location) {
        this.libraryName = libraryName;
        this.location = location;
    }

    public void showBooks(Book[] books) {
        System.out.println("Books available in the library:");
        for (Book b : books) {
            System.out.println("Title: " + b.title + ", Author: " + b.author + ", Price: $" + b.price);
        }
    }
}
