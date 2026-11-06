
import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;

    // Producer adds items to the buffer
    public synchronized void produce(int item) throws InterruptedException {

        while (buffer.size() == capacity) {
            wait();
        }

        buffer.add(item);
        System.out.println("Produced: " + item);

        notify();
    }

    // Consumer removes items from the buffer
    public synchronized int consume() throws InterruptedException {

        while (buffer.isEmpty()) {
            wait();
        }

        int item = buffer.remove();
        System.out.println("Consumed: " + item);

        notify();

        return item;
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        SharedBuffer sharedBuffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedBuffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedBuffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        // Start both threads
        producer.start();
        consumer.start();

        try {
            // Wait for both threads to finish
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Producer-Consumer completed successfully.");
    }
}
