public class Main {
    public static void main(String[] args) {
        // Send only Email
        Notifier emailNotifier = new EmailNotifier();
        System.out.println("----- Basic Notification -----");
        emailNotifier.send("Hello User!");

        // Send Email + SMS
        Notifier smsDecorator = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\n----- Email + SMS Notification -----");
        smsDecorator.send("Your OTP is 1234");

        // Send Email + SMS + Slack
        Notifier fullNotifier = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(
                                        new EmailNotifier()));
        System.out.println("\n----- Email + SMS + Slack Notification -----");
        fullNotifier.send("System Alert: CPU usage high");
    }
}
