class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toStrings() {
        return "OrderID: " + orderId + ", Name: " + customerName + ", Total: ₹" + totalPrice;
    }
}
