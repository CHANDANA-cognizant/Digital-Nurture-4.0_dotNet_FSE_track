public class Main {
    public static void main(String[] args) {
        StockMarket googleStock = new StockMarket("GOOGL");

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        googleStock.registerObserver(mobileUser);
        googleStock.registerObserver(webUser);

        googleStock.setPrice(2750.0);
        googleStock.setPrice(2800.5);

        googleStock.removeObserver(webUser);

        googleStock.setPrice(2850.0);  // Only Alice will be notified
    }
}
