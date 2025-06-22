public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Constructor to set strategy
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Method to change strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Method to execute the strategy
    public void makePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy set!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
