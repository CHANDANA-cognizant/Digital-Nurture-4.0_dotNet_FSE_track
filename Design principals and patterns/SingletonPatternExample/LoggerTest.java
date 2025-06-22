public class LoggerTest{
    public static void main(String[] args) {
        // Get the Logger instance multiple times
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages
        logger1.log("First message");
        logger2.log("Second message");

        // Check if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton confirmed).");
        } else {
            System.out.println("Different logger instances (Singleton failed).");
        }
    }
}
