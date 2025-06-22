public class Main {
    public static void main(String[] args) {
        Computer basic = new Computer.Builder("Intel i3", "4GB").build();

        Computer gaming = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4090")
            .setKeyboard("Mechanical Keyboard")
            .setMouse("Gaming Mouse")
            .build();

        System.out.println("Basic Configuration: " + basic);
        System.out.println("Gaming Configuration: " + gaming);
    }
}
