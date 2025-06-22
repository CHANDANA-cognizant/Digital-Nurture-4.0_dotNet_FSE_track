public class Logger {
    // Private static instance of the same class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Public static method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Sample method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}