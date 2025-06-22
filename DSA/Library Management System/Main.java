public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "Clean Code", "Robert C. Martin"),
            new Book(3, "Atomic Habits", "James Clear"),
            new Book(4, "1984", "George Orwell")
        };

        // Linear Search
        System.out.println("🔎 Linear Search: 'Clean Code'");
        Book result1 = LinearSearch.linearSearch(books, "Clean Code");
        System.out.println(result1 != null ? result1 : "Book not found");

        // Binary Search (requires sorting)
        BinarySearch.sortBooks(books);

        System.out.println("\n🔎 Binary Search: 'Atomic Habits'");
        Book result2 = BinarySearch.binarySearch(books, "Atomic Habits");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}
