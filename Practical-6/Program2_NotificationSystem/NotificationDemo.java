
@FunctionalInterface
interface Notifier {
    void send(String message);
}

@FunctionalInterface
interface Urgent {
    void sendUrgent(Notifier notifier, String message);
}

public class NotificationDemo {

    public static void main(String[] args) {

        // Email sender using lambda
        Notifier email = message ->
            System.out.println("Email Notification: " + message);

        // SMS sender using lambda
        Notifier sms = message ->
            System.out.println("SMS Notification: " + message);

        // Store notification senders in an array
        Notifier[] senders = { email, sms };

        // Broadcast one message through all senders
        System.out.println("Normal Notification:");

        for (Notifier sender : senders) {
            sender.send("Hello! This is a notification.");
        }

        // Urgent notification using lambda
        Urgent urgentNotification = (notifier, message) -> {
            notifier.send(message);
            notifier.send(message);
        };

        // Send urgent notification twice
        System.out.println("\nUrgent Notification:");

        urgentNotification.sendUrgent(
            email,
            "URGENT! Please respond immediately."
        );
    }
}
