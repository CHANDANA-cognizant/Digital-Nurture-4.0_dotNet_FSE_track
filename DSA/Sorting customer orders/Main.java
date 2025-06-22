public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1001, "Alice", 1500.50),
            new Order(1002, "Bob", 550.00),
            new Order(1003, "Charlie", 4200.75),
            new Order(1004, "David", 1200.30),
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        Order[] bubbleSorted = orders.clone();
        BubbleSorter.bubbleSort(bubbleSorted);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        printOrders(bubbleSorted);

        // Quick Sort
        Order[] quickSorted = orders.clone();
        QuickSorter.quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        printOrders(quickSorted);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
