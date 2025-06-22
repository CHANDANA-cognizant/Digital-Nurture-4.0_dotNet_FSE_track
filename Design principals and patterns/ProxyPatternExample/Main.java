public class Main {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature.jpg");
        Image img2 = new ProxyImage("nature.jpg");
        Image img3 = new ProxyImage("portrait.png");

        System.out.println("\n--- First time loading ---");
        img1.display();  // loads from server

        System.out.println("\n--- Reusing cached image ---");
        img2.display();  // loaded from cache

        System.out.println("\n--- New image ---");
        img3.display();  // loads from server
    }
}
