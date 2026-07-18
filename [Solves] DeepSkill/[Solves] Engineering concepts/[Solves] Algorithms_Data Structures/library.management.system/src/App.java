public class App {
    public static void main(String[] args) {
        Book[] library = {
                new Book(105, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(42, "1984", "George Orwell"),
                new Book(312, "To Kill a Mockingbird", "Harper Lee"),
                new Book(88, "The Hobbit", "J.R.R. Tolkien"),
                new Book(914, "Pride and Prejudice", "Jane Austen"),
                new Book(256, "Dune", "Frank Herbert"),
                new Book(73, "Project Hail Mary", "Andy Weir")
        };
        Sorting.customSort(library);

        int found = Searching.binarySearch(library, 256, 0, library.length - 1);
        if (found != -1) {
            System.out.println("Book Found");
            System.out.println(library[found].title);
            System.out.println(library[found].author);
            System.out.println(library[found].bookId);
        }else{
            System.out.println("Book Not Found");
        }

    }
}
