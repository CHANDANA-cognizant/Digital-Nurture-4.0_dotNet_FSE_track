import java.util.Arrays;
import java.util.Comparator;

class BinarySearch {
    public static void sortBooks(Book[] books) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
