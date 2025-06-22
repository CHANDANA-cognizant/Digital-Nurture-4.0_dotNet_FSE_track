public class Main {
    public static void main(String[] args) {
        // Pay using Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "Alice");
        PaymentContext context = new PaymentContext(creditCard);
        context.makePayment(500.0);

        // Switch to PayPal
        PaymentStrategy paypal = new PayPalPayment("alice@example.com");
        context.setPaymentStrategy(paypal);
        context.makePayment(300.0);
    }
}
