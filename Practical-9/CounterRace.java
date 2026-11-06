
class CounterRace {

    static int counter = 0;
    static final int THREADS = 10;
    static final int INCREMENTS = 100000;

    // Increment without synchronization
    static void increment() {
        counter++;
    }

    // Increment with synchronization
    static synchronized void incrementSync() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {

        // Without synchronization
        counter = 0;

        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    increment();
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Expected Counter: " + (THREADS * INCREMENTS));
        System.out.println("Without Synchronization: " + counter);

        // With synchronization
        counter = 0;

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    incrementSync();
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("With Synchronization: " + counter);
    }
}
